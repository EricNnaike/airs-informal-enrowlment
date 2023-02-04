package com.app.AIRS.controller.nimc;


import com.app.AIRS.Utils.MessageUtil;
import com.app.AIRS.Utils.OkHttp3Util;
import com.app.AIRS.Utils.ResourceUtil;
import com.app.AIRS.Utils.Utils;
import com.app.AIRS.api_response.ApiResponseServiceImpl;
import com.app.AIRS.dto.Nimc.CreateTokenDto;
import com.app.AIRS.dto.Nimc.SearchWithNINDto;
import com.app.AIRS.entity.FileModel;
import com.app.AIRS.entity.ImageResolution;
import com.app.AIRS.entity.NIN;
import com.app.AIRS.entity.UserDemographicIndividual;
import com.app.AIRS.errors.ApiError;
import com.app.AIRS.repository.NinRepository;
import com.app.AIRS.service.FileUploadBase64Service;
import com.app.AIRS.service.ImageResolutionService;
import com.app.AIRS.serviceImpl.TinGenerationService;
import com.google.gson.Gson;
import com.app.AIRS.nin.creat_token.InnerCreateTokenResponsePojo;
import com.app.AIRS.nin.search_by_nin.FindByNinDataResponsePojo;
import com.app.AIRS.nin.search_by_nin.InnerFindByNINResponsePojo;
import com.app.AIRS.service.NinSearchService;
import com.app.AIRS.service.NinService;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

@RestController
public class PublicNimcController {

    @Value("${nin.domain}")
    private String ninDomain;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    @Value("${hash.password}")
    private String hashPassword;

    @Value("${org.id}")
    private String orgId;

    private final OkHttp3Util okHttp3Util;

    private final MessageUtil messageUtil;

    private final ApiResponseServiceImpl apiResponseService;
    private final Logger logger = Logger.getLogger(PublicNimcController.class.getName());

    private final NinService ninService;

    private final FileUploadBase64Service fileUploadBase64Service;

    private final NinSearchService ninSearchService;

    private final ImageResolutionService imageResolutionService;
//    private final PortalAccountService portalAccountService;

    private final Environment environment;

    @Autowired
    private NinRepository ninRepository;
    @Autowired
    private TinGenerationService tinGenerationService;


    public PublicNimcController(OkHttp3Util okHttp3Util, MessageUtil messageUtil,
                                FileUploadBase64Service fileUploadBase64Service,
                                ApiResponseServiceImpl apiResponseService,
                                NinService ninService,
                                ImageResolutionService imageResolutionService,
                                NinSearchService ninSearchService,
                                Environment environment) {
        this.okHttp3Util = okHttp3Util;
        this.messageUtil = messageUtil;
        this.apiResponseService = apiResponseService;
        this.ninService = ninService;
        this.ninSearchService = ninSearchService;
        this.imageResolutionService= imageResolutionService;
        this.fileUploadBase64Service = fileUploadBase64Service;
        this.environment = environment;
    }

    @PostMapping("/nimc/create-token")
    public ResponseEntity<?> creteToken() {
        ApiError apiError = null;

        try {

            CreateTokenDto createTokenDto = new CreateTokenDto();
            createTokenDto.setOrgId(orgId);
            createTokenDto.setUsername("MAkinyele");
            createTokenDto.setPassword(hashPassword);

            Gson gson = new Gson();

            String json = gson.toJson(createTokenDto);
            String url = ninDomain+"/create-token";
            String xmlString = "";
            xmlString = this.okHttp3Util.post(url, json);

            if(xmlString.isEmpty()) {
                apiError = new ApiError(HttpStatus.OK.value(),
                        HttpStatus.OK,
                        messageUtil.getMessage("nimc.response.failed", "en"),
                        false,
                        new ArrayList<>(),
                        null);

                return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
            }

            InnerCreateTokenResponsePojo innerCreateTokenResponsePojo = this.ninSearchService.createToken(xmlString);
            if(innerCreateTokenResponsePojo.getLoginObject() == null) {
                apiError = new ApiError(HttpStatus.OK.value(),
                        HttpStatus.OK,
                        messageUtil.getMessage("nimc.response.failed", "en"),
                        false,
                        new ArrayList<>(),
                        null);

                return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
            }

            String token = Utils.removeNewLineAndSpace(innerCreateTokenResponsePojo.getLoginString());

            apiError = new ApiError(HttpStatus.OK.value(),
                    HttpStatus.OK,
                    messageUtil.getMessage("nimc.response", "en"),
                    true,
                    new ArrayList<>(),
                    token);

            return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());

        } catch (Exception e) {
            return apiResponseService.internalServerError();
        }
    }

    @PostMapping("/nimc/search-with-nin/{nin_number}")
    public Long searchWithNIN(@PathVariable("nin_number") String ninNumber) {


        ApiError apiError = null;

        if(ninNumber.isEmpty()) {
            apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),
                    HttpStatus.BAD_REQUEST,
                    messageUtil.getMessage("nimc.nin.required", "en"),
                    false,
                    new ArrayList<>(),
                    null);

            return 0L;
        }

        try {
            NIN nin = this.ninService.findByNIN(ninNumber);

            if(nin == null) {
                CreateTokenDto createTokenDto = new CreateTokenDto();
                createTokenDto.setOrgId(orgId);
                createTokenDto.setUsername("MAkinyele");
                createTokenDto.setPassword(hashPassword);

                Gson gson = new Gson();

                String jsonForToken = gson.toJson(createTokenDto);
                String url = ninDomain+"/create-token";

                String xmlStringForToken;
                if(environment.acceptsProfiles(Profiles.of("local-nin"))) {
                    // String path = ResourceUtil.getResourceAsUrl("nin/create-token.txt").getPath();
                    xmlStringForToken = IOUtils.toString(ResourceUtil.getResourceAsStream("nin/create-token.txt"));
                } else {
                    logger.info("Made api call");
                    String ting = tinGenerationService.generateNewTinNumber();
                    System.out.println(ting);
                    xmlStringForToken = this.okHttp3Util.post(url, jsonForToken);
                }
                if(xmlStringForToken == null || xmlStringForToken.isEmpty()) {
                    apiError = new ApiError(HttpStatus.OK.value(),
                            HttpStatus.OK,
                            messageUtil.getMessage("nimc.response.failed ", "en"),
                            false,
                            new ArrayList<>(),
                            null);

                    return 0L;
                }


                InnerCreateTokenResponsePojo innerCreateTokenResponsePojo = this.ninSearchService.createToken(xmlStringForToken);
                if(innerCreateTokenResponsePojo.getLoginObject() == null) {
                    apiError = new ApiError(HttpStatus.OK.value(),
                            HttpStatus.OK,
                            messageUtil.getMessage("nimc.response.failed ", "en"),
                            false,
                            new ArrayList<>(),
                            null);

                    return 0L;
                }


                String token = Utils.removeNewLineAndSpace(innerCreateTokenResponsePojo.getLoginString());
                SearchWithNINDto searchWithNINDto = new SearchWithNINDto();
                searchWithNINDto.setNin(ninNumber);
                searchWithNINDto.setToken(token);

                String json = gson.toJson(searchWithNINDto);

                String xmlString;
                if(environment.acceptsProfiles(Profiles.of("local-nin"))) {
                    xmlString = IOUtils.toString(ResourceUtil.getResourceAsUrl("nin/nin-user-search-response.txt"));
                } else {
                    xmlString = this.okHttp3Util.post(ninDomain+"/search-with-nin", json);
                }

                if(xmlString == null || xmlString.isEmpty()) {
                    apiError = new ApiError(HttpStatus.OK.value(),
                            HttpStatus.OK,
                            messageUtil.getMessage("nimc.response.failed", "en"),
                            false,
                            new ArrayList<>(),
                            null);

                    return 0L;
                }

                InnerFindByNINResponsePojo innerFindByNINResponsePojo = this.ninSearchService.ninSearch(xmlString);
                if(!innerFindByNINResponsePojo.getReturnMessage().equalsIgnoreCase("success")) {
                    apiError = new ApiError(HttpStatus.OK.value(),
                            HttpStatus.OK,
                            innerFindByNINResponsePojo.getReturnMessage(),
                            false,
                            new ArrayList<>(),
                            null);

                    return 0L;
                }
                FindByNinDataResponsePojo findByNinDataResponsePojo = innerFindByNINResponsePojo.getData();

                //Upload image
                ImageResolution imageResolutionForSignature = null;
                ImageResolution imageResolutionForPhoto = null;

                String fileCodeForPhoto;
                String fileCodeForSignature = null;

                try {
                    FileModel fileModelForSignature = this.fileUploadBase64Service.upload(findByNinDataResponsePojo.getSignature());
                    imageResolutionForSignature = this.imageResolutionService.findByFileCode(fileModelForSignature.getCode());
                    fileCodeForSignature = fileModelForSignature.getCode();
                } catch(IllegalArgumentException iae) {
                    logger.info(iae.getMessage());
//                    return this.apiResponseService.photoNotFoundWithNIN();
                }

                try {
                    FileModel fileModelForPhoto = this.fileUploadBase64Service.upload(findByNinDataResponsePojo.getPhoto());
                    imageResolutionForPhoto = this.imageResolutionService.findByFileCode(fileModelForPhoto.getCode());
                    fileCodeForPhoto = fileModelForPhoto.getCode();
                } catch(IllegalArgumentException iae) {
                    logger.info(iae.getMessage());
                    return null;
                }
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");


                NIN nnin = new NIN();

                nnin.setTitle(findByNinDataResponsePojo.getTitle());
                nnin.setSignature(imageResolutionForSignature.getUrl());
                nnin.setResidenceLga(findByNinDataResponsePojo.getResidenceLga());
                nnin.setPhoto(imageResolutionForPhoto.getUrl());
                nnin.setNin(findByNinDataResponsePojo.getNin());
                nnin.setProfession(findByNinDataResponsePojo.getProfession());
                nnin.setTelePhoneNumber(findByNinDataResponsePojo.getTelePhoneNumber());
                nnin.setFirstName(findByNinDataResponsePojo.getFirstName());
                nnin.setMiddleName(findByNinDataResponsePojo.getMiddleName());
                nnin.setSurname(findByNinDataResponsePojo.getSurname());
                nnin.setBirthLGA(findByNinDataResponsePojo.getBirthLGA());
                nnin.setSelfOriginPlace(findByNinDataResponsePojo.getSelfOriginPlace());
                nnin.setBirthCountry(findByNinDataResponsePojo.getBirthCountry());
                nnin.setBirthState(findByNinDataResponsePojo.getBirthState());
                nnin.setCentralId(findByNinDataResponsePojo.getCentralId());
                nnin.setEducationalLevel(findByNinDataResponsePojo.getEducationalLevel());
                nnin.setResidenceAddressLine1(findByNinDataResponsePojo.getResidenceAddressLine1());
                nnin.setBirthState(findByNinDataResponsePojo.getBirthState());
                nnin.setEmail(findByNinDataResponsePojo.getEmail());
                nnin.setSelfOriginLga(findByNinDataResponsePojo.getSelfOriginLga());
                nnin.setReligion(findByNinDataResponsePojo.getReligion());
                nnin.setMaritalStatus(findByNinDataResponsePojo.getMaritalStatus());
                nnin.setResidenceTown(findByNinDataResponsePojo.getResidenceTown());
                nnin.setResidenceState(findByNinDataResponsePojo.getResidenceState());
                nnin.setSelfOriginState(findByNinDataResponsePojo.getSelfOriginState());
                nnin.setGender(findByNinDataResponsePojo.getGender());
//                Date date = formatter.parse(findByNinDataResponsePojo.getBirthDate());
                nnin.setBirthDate(findByNinDataResponsePojo.getBirthDate());
                NIN found = ninRepository.save(nnin);

                return found.getId();

            }

            return nin.getId();

        } catch (Exception e) {
            logger.info("error found "  + e.getMessage());
            return null;
        }

    }

    @PostMapping("/nimc/search-with-phone-number")
    public ResponseEntity<?> searchWithPhoneNumber() {
        ApiError apiError = null;

        try {

            this.okHttp3Util.post(ninDomain+"/create-token");

            apiError = new ApiError(HttpStatus.OK.value(),
                    HttpStatus.OK,
                    messageUtil.getMessage("nationalities.fetched", "en"),
                    true,
                    new ArrayList<>(),
                    null);
            return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return apiResponseService.internalServerError();
        }
    }



    @RequestMapping(value = "/informal/sector/{asin}")
    public UserDemographicIndividual getInformalSectioFromTax(@PathVariable String asin) {

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        ResponseEntity<UserDemographicIndividual> responseRC = null;
        UserDemographicIndividual userinfo1 = null;

        String url = "http://localhost:8787/api/informal/sector/verification/" + asin;
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        try {
            responseRC = restTemplate.exchange(builder.toUriString(),HttpMethod.GET,entity, UserDemographicIndividual.class);

            userinfo1 = responseRC.getBody();
            System.out.println(responseRC.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  userinfo1;

    }

}
