package com.app.AIRS.serviceImpl;

import com.app.AIRS.Enum.*;
import com.app.AIRS.Utils.EmailService;
import com.app.AIRS.Utils.PredicateExtractor;
import com.app.AIRS.Utils.Utils;
import com.app.AIRS.dto.*;
import com.app.AIRS.entity.*;
import com.app.AIRS.entity.lgaArea.LgaAreas;
import com.app.AIRS.entity.userManagement.PortalUser;
import com.app.AIRS.entity.userManagement.Roles;
import com.app.AIRS.repository.*;
import com.app.AIRS.repository.app.AppRepository;
import com.app.AIRS.security.JwtService;
import com.app.AIRS.service.UserManagementService;
import com.app.AIRS.service.UtilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UtilityServiceImpl implements UtilityService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private TinRepository tinRepository;
    @Autowired
    private TinGenerationService tinGenerationService;
    @Autowired
    private MarketRepository marketRepository;
    @Autowired
    private LgaRepository lgaRepository;
    @Autowired
    private LineRepository lineRepository;
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private TransportRouteRepository transportRouteRepository;
    @Autowired
    private StreetRepository streetRepository;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private OccupantRepository occupantRepository;
    @Autowired
    private NinRepository ninRepository;
    @Autowired
    private VersionControlRepository versionControlRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private LgaAreaRepository lgaAreaRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private BusinessTypeRepository businessTypeRepository;
    @Autowired
    private BusinessCategoryRepository businessCategoryRepository;
    @Autowired
    private Corperaterepository corperaterepository;
    @Autowired
    private TransportDriverRepository driverRepository;
    @Autowired
    private SmsRepository smsRepository;
    @Autowired
    private ShopOwnerReposiroty shopOwnerReposiroty;
    @Autowired
    private BuildingTypeRepository buildingTypeRepository;
    @Autowired
    private BuildingCategoryRepository buildingCategoryRepository;


    private final UserManagementService userManagementService;
    private final RolesRepository rolesRepository;
    private final AppRepository appRepository;
    private final PredicateExtractor predicateExtractor;
    private final JwtService jwtService;
    private final PortalUserRepository portalUserRepository;


    @Override
    public ShopDto saveShop(Shop shop) {

        Shop foundShop = shopRepository.findByShop_NumberAndLine(shop.getShop_number(), shop.getLine());
        if (foundShop != null){
            ShopDto dto = new ShopDto();
            dto.setMarket(foundShop.getMarket().getName());
            dto.setLine(foundShop.getLine().getName());
            dto.setShop(foundShop.getShop_number());
            dto.setLineNo(foundShop.getLine().getId().toString());
            return dto;
        }else{
            shop.setStatus(GenericStatusConstant.ACTIVE);
            shop.setCreatedBy(jwtService.user);
            shop.setCreatedAt(LocalDateTime.now());
            Shop shop1 = shopRepository.save(shop);

            ShopDto dto = new ShopDto();
            dto.setMarket(shop1.getMarket().getName());
            dto.setLine(shop1.getLine().getName());
            dto.setShop(shop1.getShop_number());
            dto.setLineNo(shop1.getLine().getId().toString());
            return dto;
        }
    }

    @Override
    public List<ShopOwnerDto> getUser(ShopDto shopDto) {

        List<ShopOwnerDto> shopOwnerDtos = new ArrayList<>();
        Lines lines  = lineRepository.findById(Long.parseLong(shopDto.getLineNo())).get();

        Shop shop = shopRepository.findByShop_NumberAndLine(shopDto.getShop(), lines);
        List<ShopOwner> shopOwner = shopOwnerReposiroty.findByShop(shop);

        shopOwner.forEach(emp->{
            ShopOwnerDto dto = new ShopOwnerDto();
            Tin tin = tinRepository.findFirstByPortalUser(emp.getPortalUser());
            dto.setName(emp.getPortalUser().getDisplayName());
            dto.setPhone(emp.getPortalUser().getPhoneNumber());
            dto.setAddress(emp.getPortalUser().getAddress());
            dto.setEmail(emp.getPortalUser().getEmail());
            dto.setPhoto(emp.getNin().getPhoto());
            dto.setTinnumber(tin.getTinNumber());
            shopOwnerDtos.add(dto);
        });





        return shopOwnerDtos;
    }

    @Override
    public Long saveTransport(TransportDto transportDto) {

        UserDto dto = new UserDto();
        PortalUser portalUser = new PortalUser();
        Transport transport = new Transport();
        PortalUser user = portalUserRepository.findFirstByUsernameIgnoreCase(transportDto.getEmail());
        NIN nin = ninRepository.findByNin(transportDto.getNin());
        Tin tin = new Tin();
        Tin tins = new Tin();
        Card card = new Card();
        String tinNumber = tinGenerationService.generateNewTinNumber();

        if (user != null){
            portalUser = user;
        }
        if (user == null){
            dto.setEmail(transportDto.getEmail());
            dto.setAddress(transportDto.getAddress());
            dto.setFirstName(transportDto.getFirstName());
            dto.setLastName(transportDto.getLastName());
            dto.setLga(transportDto.getLga());
            dto.setPhoneNumber(transportDto.getPhoneNumber());
            dto.setPhoto(nin.getPhoto());
            dto.setNin(transportDto.getNin());
            dto.setPassword(tinNumber);
            dto.setRole("GENERAL_USER");
            Roles role = rolesRepository.findByNameIgnoreCase(dto.getRole()).orElseThrow(RuntimeException::new);
            portalUser = userManagementService.createUser(dto, jwtService.user, role);

        }
        Route route = routeRepository.findById(transportDto.getTransportType()).get();
        Lga lga = lgaRepository.findById(transportDto.getLga()).get();
        TransportRoute transportRoute = transportRouteRepository.findById(transportDto.getRoute()).get();

        transport.setTransport(route);
        transport.setLga(lga);
        transport.setPaymentMode(transportDto.getPaymentMode());
        transport.setPortalUser(portalUser);
        transport.setNin(nin);
        transport.setRoute(transportRoute);
        transport.setStatus(GenericStatusConstant.ACTIVE);
        transport.setCreatedAt(LocalDateTime.now());
        transport.setPlateNumber(transportDto.getPlateNumebr());
        transport.setLastUpdatedAt(LocalDateTime.now());
        transport.setCreatedBy(jwtService.user);
        transport.setType(TransportType.OWNER);
        Transport createdtransport = transportRepository.save(transport);


        tin.setPortalUser(portalUser);
        tin.setTinType(TinType.TRANSPORT);
        tin.setTinNumber("T" + tinNumber);
        tins = tinRepository.save(tin);

        card.setAddress(nin.getResidenceAddressLine1());
        card.setCardStatus(CardStatus.NOT_PRINTED);
        card.setCardType(CardType.TRANSPORT_STICKER);
        card.setRoute(createdtransport.getRoute().getName());
        card.setType(createdtransport.getTransport().getName());
        card.setPhoto(nin.getPhoto());
        card.setPhoneNumber(nin.getTelePhoneNumber());
        card.setName(createdtransport.getPortalUser().getDisplayName());
        card.setPlateNumber(transport.getPlateNumber());
        card.setTin(tins.getTinNumber());
        card.setStatus(GenericStatusConstant.ACTIVE);
        card.setCreatedBy(jwtService.user);
        card.setCreatedAt(LocalDateTime.now());
        card.setLastUpdatedAt(LocalDateTime.now());

        cardRepository.save(card);

        String phoneNumber = Utils.removeFirstChar(nin.getTelePhoneNumber());
        Utils.Confirm("+234" + phoneNumber, "Transport", tins.getTinNumber(), nin.getSurname());


        return createdtransport.getId();
    }

    @Override
    public TransportDto getTransportUser(Long id) {
        TransportDto dto = new TransportDto();

        Transport transportUser= transportRepository.findById(id).get();
        PortalUser user = portalUserRepository.findById(transportUser.getPortalUser().getId()).get();
        Tin tin =tinRepository.findFirstByPortalUserAndTinType(user, TinType.TRANSPORT);
        Lga lga = lgaRepository.findById(transportUser.getLga().getId()).get();
        NIN nin = ninRepository.findById(transportUser.getNin().getId()).get();


        dto.setTransportName(transportUser.getRoute().getName());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setTinNumebr(tin.getTinNumber());
        dto.setCategory("Transport");
        dto.setCityName(nin.getResidenceAddressLine1());
        dto.setPlateNumebr(transportUser.getPlateNumber());
        dto.setLgaName(lga.getName());
        dto.setPhoto(nin.getPhoto());

        System.out.println(dto);

        return dto;
    }

    @Override
    public Long saveStreet(Street street) {
        Street street1 =  streetRepository.save(street);
        return street1.getId();
    }

    @Override
    public Long saveProperty(PropertyDto property) {
        System.out.println(property);
        Street street = streetRepository.findById(property.getStreetsId()).get();
        LgaAreas lgaAreas = lgaAreaRepository.findById(property.getAreaId()).get();
        Building_category category = buildingCategoryRepository.findFirstByNameIgnoreCase(property.getCategory());
        Building_type type = buildingTypeRepository.findFirstByNameIgnoreCase(property.getType());
        Property property1 = new Property();
        property1.setStreet(street);
        property1.setArea(lgaAreas);
        property1.setHouseNumber(property.getHouseNumber());
        property1.setCategory(category);
        property1.setApartment(property.getFloors());
        property1.setType(type);

        property1.setCreatedBy(jwtService.user);
        property1.setStatus(GenericStatusConstant.ACTIVE);
        property1.setCreatedAt(LocalDateTime.now());
        Property p = propertyRepository.save(property1);
        return p.getId();
    }

    @Override
    public Long saveOccupant(Occupant occupant) {
        occupant.setStatus(GenericStatusConstant.ACTIVE);
        occupant.setCreatedAt(LocalDateTime.now());
        occupant.setLastUpdatedAt(LocalDateTime.now());
        occupant.setCreatedBy(jwtService.user);
        Occupant occupant1 = occupantRepository.save(occupant);
        return occupant1.getId();
    }

    @Override
    public Long saveDriver(DriverDto transportDriverUser) {

        UserDto dto = new UserDto();
        PortalUser portalUser = new PortalUser();
        TransportDriverUser transport = new TransportDriverUser();
        Transport owner = transportRepository.findById(transportDriverUser.getOwner()).get();
        NIN nin = ninRepository.findByNin(transportDriverUser.getNin());
        Tin tin = tinRepository.findFirstByPortalUserAndTinType(owner.getPortalUser(), TinType.TRANSPORT);

        Card card = new Card();


        transport.setPhoto(nin.getPhoto());
        transport.setAddress(transportDriverUser.getAddress());
        transport.setOwner(owner);
        transport.setFirstName(transportDriverUser.getFirstName());
        transport.setLastName(transportDriverUser.getLastName());
        transport.setEmail(transportDriverUser.getEmail());
        transport.setNin(nin);
        transport.setStatus(GenericStatusConstant.ACTIVE);
        transport.setCreatedAt(LocalDateTime.now());
        transport.setLastUpdatedAt(LocalDateTime.now());
        transport.setCreatedBy(jwtService.user);
        TransportDriverUser createdtransport = driverRepository.save(transport);

        owner.setDriverUser(createdtransport);
        transportRepository.save(owner);


        card.setAddress(nin.getResidenceAddressLine1());
        card.setCardStatus(CardStatus.NOT_PRINTED);
        card.setCardType(CardType.TRANSPORT);
        card.setRoute(owner.getRoute().getName());
        card.setPhoto(nin.getPhoto());
        card.setPhoneNumber(nin.getTelePhoneNumber());
        card.setName(createdtransport.getFirstName() + " "+ createdtransport.getLastName());
        card.setTin(tin.getTinNumber());
        card.setStatus(GenericStatusConstant.ACTIVE);
        card.setCreatedBy(jwtService.user);
        card.setCreatedAt(LocalDateTime.now());
        card.setType(owner.getTransport().getName());
        card.setLastUpdatedAt(LocalDateTime.now());

        cardRepository.save(card);

        return createdtransport.getId();
    }

    @Override
    public DriverDto getDriverUser(Long id) {

        DriverDto dto = new DriverDto();

        TransportDriverUser transportUser= driverRepository.findById(id).get();
        Transport transport = transportRepository.findById(transportUser.getOwner().getId()).get();
        Tin tin =tinRepository.findFirstByPortalUserAndTinType(transport.getPortalUser(), TinType.TRANSPORT);
        Lga lga = lgaRepository.findById(transport.getLga().getId()).get();
        NIN nin = ninRepository.findById(transportUser.getNin().getId()).get();


        dto.setTransportName(transport.getRoute().getName());
        dto.setFirstName(transportUser.getFirstName());
        dto.setLastName(transportUser.getLastName());
        dto.setTinNumebr(tin.getTinNumber());
        dto.setCategory("Driver");
        dto.setCityName(nin.getResidenceAddressLine1());
        dto.setPlateNumebr(transport.getPlateNumber());
        dto.setLgaName(lga.getName());
        dto.setPhoto(nin.getPhoto());

        System.out.println(dto);

        return dto;
    }

    @Override
    public SmsDto getNinForSms(Long id) {
        SmsDto smsDto = new SmsDto();

        NIN nin = ninRepository.findById(id).get();

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        // this will convert any number sequence into 6 character.
        String smsCode =  String.format("%06d", number);
        String PhoneNumber = Utils.removeFirstChar(nin.getTelePhoneNumber());
        Utils.sendSms("+234" + PhoneNumber, "Informal Sector", smsCode);


        Sms sms = new Sms();
        sms.setToken(smsCode);
        sms.setPhoneNumber("+234"+nin.getTelePhoneNumber());
        sms.setStatus(GenericStatusConstant.ACTIVE);
        sms.setCreatedAt(LocalDateTime.now());
        sms.setUsed(false);
        smsRepository.save(sms);

        smsDto.setCode(smsCode);
        smsDto.setPhone("+234"+PhoneNumber);
        System.out.println(smsDto);
        return smsDto;
    }

    @Override
    public VersionDto getVersion() {
        VersionControl v = versionControlRepository.findFirstById(1L);
        VersionDto dto = new VersionDto();
        dto.setVersion(v.getVersion());
        dto.setDescription(v.getDescription());
        dto.setUrl(v.getUrl());

        return dto;
    }

    @Override
    public Long saveForAsin(AsinDto asinDto) {
        NIN nin = ninRepository.findById(asinDto.getNinId()).get();
        UserDto dto = new UserDto();
        PortalUser portalUser = new PortalUser();
        PortalUser user = portalUserRepository.findFirstByUsernameIgnoreCase(nin.getEmail());
        LgaAreas lgaAreas = lgaAreaRepository.findById(asinDto.getArea()).get();
        Tin tin = new Tin();
        Tin tins = new Tin();
        User user1 = new User();
        Card card = new Card();
        String tinNumber = tinGenerationService.generateNewTinNumber();

        if (user != null){
            User asinUser = userRepository.findFirstByNin(nin);
            if (asinUser != null){
                return null;
            }
            portalUser = user;
        }
        if (user == null){
            if(nin.getEmail() != null) {
                dto.setEmail(nin.getEmail());
            }
            if (nin.getEmail() == null){
                dto.setEmail(nin.getNin());
            }
            dto.setAddress(nin.getResidenceAddressLine1());
            dto.setFirstName(nin.getFirstName());
            dto.setLastName(nin.getSurname());
            dto.setLga(asinDto.getLga());
            dto.setPhoneNumber(nin.getTelePhoneNumber());
            dto.setPhoto(nin.getPhoto());
            dto.setNin(nin.getNin());
            dto.setPassword(tinNumber);
            dto.setRole("GENERAL_USER");
            Roles role = rolesRepository.findByNameIgnoreCase(dto.getRole()).orElseThrow(RuntimeException::new);
            portalUser = userManagementService.createUser(dto, jwtService.user, role);

        }
        user1.setStatus(GenericStatusConstant.ACTIVE);
        user1.setPortalUser(portalUser);
        user1.setHouseNumber(asinDto.getHouseNumber());
        user1.setNin(nin);
        user1.setLandmark(asinDto.getLandMark());
        user1.setCreatedBy(jwtService.user);
        user1.setCreatedAt(LocalDateTime.now());
        user1.setTimeCreated(LocalDateTime.now());
        user1.setLastUpdatedAt(LocalDateTime.now());
        User createdUser = userRepository.save(user1);


        tin.setPortalUser(portalUser);
        tin.setTinType(TinType.INDIVIDUAL);
        tin.setTinNumber(tinGenerationService.generateNewTinNumber());
        tins = tinRepository.save(tin);

        card.setTin(tins.getTinNumber());
        card.setName(nin.getFirstName() + " " + nin.getSurname());
        card.setPhoneNumber(nin.getTelePhoneNumber());
        card.setPhoto(nin.getPhoto());
        card.setCardType(CardType.ENUMERATION);
        card.setCardStatus(CardStatus.NOT_PRINTED);
        card.setStatus(GenericStatusConstant.ACTIVE);
        card.setAddress(nin.getResidenceAddressLine1() + " " + lgaAreas.getName() + " " + nin.getResidenceLga());
        card.setCreatedBy(jwtService.user);
        card.setCreatedAt(LocalDateTime.now());
        card.setLastUpdatedAt(LocalDateTime.now());
        cardRepository.save(card);

        String phoneNumber = Utils.removeFirstChar(nin.getTelePhoneNumber());
        Utils.Confirm("+234" + phoneNumber, "ASIN", tins.getTinNumber(), nin.getSurname());

        return createdUser.getId();
    }

    @Override
    public PhoneDto getPhoneNumberForSms(PhoneDto phone) {
        PhoneDto smsDto = new PhoneDto();

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        // this will convert any number sequence into 6 character.
        String smsCode =  String.format("%06d", number);
        String PhoneNumber = Utils.removeFirstChar(phone.getPhoneNumber());
        Utils.sendSms("+234" + PhoneNumber, "Informal Sector", smsCode);

        smsDto.setCode(smsCode);
        smsDto.setPhoneNumber("+234"+PhoneNumber);
        System.out.println(smsDto);

        try {
//            emailService.sendMySimpleEmail("Demand Notice for the payment of Fire Service Assessment", "",
//                    "anachunaabuchi@gmail.com", "FIRE SERVICE ASSESSMENT", "98899009887", "anachunaabuchi@gmail.",
//                    "anachunaabuchi@gmail.", phone.getPhoneNumber(), "anachunaabuchi@gmail",
//                    "Fire Service Assessment", "61001001-12040465", "anachunaabuchi@gmail.",
//                    "Fire Service Assessment", "12233669554", "2022", LocalDateTime.now(), "NO 1 ESTHER OBIAKOR ESTATE AGU-AWKA");
        } catch (Exception e) {
//            e.printStackTrace();
        }

        return smsDto;
    }

    @Override
    public List<BusinessType> getBusinessType(){
        List<BusinessType> type = businessTypeRepository.findAll();
        return type;
    }
    @Override
    public List<BusinessClassification> getBusinessClassification(Long id){
        List<BusinessClassification> classification = businessCategoryRepository.findByNatureOfBusiessFk(id);
        return classification;
    }

    @Override
    public CorperateDto saveCorperate(Corperate corperate) {
        UserDto dto = new UserDto();
        PortalUser portalUser = new PortalUser();
        PortalUser user = portalUserRepository.findFirstByUsernameIgnoreCase(corperate.getEmail());
        LgaAreas lgaAreas = lgaAreaRepository.findById(corperate.getLga()).get();
        Tin tin = new Tin();
        Tin tins = new Tin();
        Corperate user1 = new Corperate();
        Card card = new Card();

        if (user != null){
            Corperate corperateUser = corperaterepository.findFirstByEmail(corperate.getEmail());
            if (corperateUser != null){
                return null;
            }
        }


        String tinNumber = tinGenerationService.generateNewTinNumber();
        dto.setEmail(corperate.getEmail());
        dto.setAddress(corperate.getAddress());
        dto.setFirstName(corperate.getCorperateName());
        dto.setLastName(corperate.getCorperateName());
        dto.setLga(corperate.getLga());
        dto.setPhoneNumber(corperate.getPhonenumber());
        dto.setPassword(tinNumber);
        dto.setRole("GENERAL_USER");
        Roles role = rolesRepository.findByNameIgnoreCase(dto.getRole()).orElseThrow(RuntimeException::new);
        portalUser = userManagementService.createUser(dto, jwtService.user, role);


        corperate.setStatus(GenericStatusConstant.ACTIVE);
        corperate.setPortalUser(portalUser);
        corperate.setTinNumber(tinNumber);
        corperate.setCreatedBy(jwtService.user);
        corperate.setCreatedAt(LocalDateTime.now());
        Corperate createdUser = corperaterepository.save(corperate);


        tin.setPortalUser(portalUser);
        tin.setTinType(TinType.CORPERATE);
        tin.setTinNumber(tinNumber);
        tins = tinRepository.save(tin);

        card.setTin(tinNumber);
        card.setName(corperate.getCorperateName());
        card.setPhoneNumber(corperate.getPhonenumber());
        card.setCardType(CardType.CORPORATE);
        card.setCardStatus(CardStatus.NOT_PRINTED);
        card.setStatus(GenericStatusConstant.ACTIVE);
        card.setAddress(corperate.getAddress() + " " + lgaAreas.getName() + " " + corperate.getState());
        card.setCreatedBy(jwtService.user);
        card.setCreatedAt(LocalDateTime.now());
        card.setLastUpdatedAt(LocalDateTime.now());
        cardRepository.save(card);

        CorperateDto dto1 = new CorperateDto();
        dto1.setCorperateName(corperate.getCorperateName());
        dto1.setTinNumber(tinNumber);
        dto1.setBusiness(corperate.getCompanyType());
        dto1.setEmail(corperate.getEmail());
        dto1.setCategory(corperate.getCompanyWork());
        dto1.setPhoneNumber(corperate.getPhonenumber());
        dto1.setRcnumber(corperate.getRcNumber());
        dto1.setAddress(corperate.getStreet() + " " +corperate.getAddress());

        String phoneNumber = Utils.removeFirstChar(corperate.getPhonenumber());
        try{
            Utils.Confirm("+234" + phoneNumber, "ASIN", tins.getTinNumber(), corperate.getCorperateName());
        }catch (Exception e){
            System.out.println(e);
        }

        return dto1;
    }

    @Override
    public List<AsinDto> searchUser(SearchDto user) {

        List<AsinDto> asinDtos = new ArrayList<>();
        Tin tin = new Tin();

        PortalUser portalUser = new PortalUser();
        AsinDto asinDto = new AsinDto();

        if (user.getAsin() != null){
            tin = tinRepository.findFirstByTinNumber(user.getAsin());
            portalUser = tin.getPortalUser();
        }
        if (user.getNumber() != null && user.getNumber() != ""){
            portalUser = portalUserRepository.findFirstByPhoneNumber(user.getNumber());
            tin = tinRepository.findFirstByPortalUser(portalUser);
        }
        if (user.getEmail() != null && user.getEmail() != ""){
            portalUser = portalUserRepository.findByUsernameIgnoreCase(user.getEmail());
            tin = tinRepository.findFirstByPortalUser(portalUser);
        }

        asinDto.setAsin(tin.getTinNumber());
        asinDto.setAddress(portalUser.getAddress());
        asinDto.setEmail(portalUser.getEmail());
        asinDto.setPhoneNumber(portalUser.getPhoneNumber());
        asinDto.setName(portalUser.getDisplayName());
        asinDto.setPhoto(portalUser.getImage());
        asinDtos.add(asinDto);

        return asinDtos;
    }

    @Override
    public SmsDto getCorperateForSms(String phoneNumber) {
        SmsDto smsDto = new SmsDto();

        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        // this will convert any number sequence into 6 character.
        String smsCode =  String.format("%06d", number);
        String PhoneNumber = Utils.removeFirstChar(phoneNumber);
        Utils.sendSms("+234" + PhoneNumber, "Informal Sector", smsCode);


        smsDto.setCode(smsCode);
        smsDto.setPhone("+234"+PhoneNumber);
        System.out.println(smsDto);
        return smsDto;
    }

    @Override
    public ShopOwnerDto saveShopOwner(ShopOwnerDto shop) {
        Lines lines = lineRepository.findById(Long.parseLong(shop.getLine())).get();
        Shop shop1 = shopRepository.findByShop_NumberAndLine(shop.getShop(), lines);
        NIN nin = ninRepository.findByNin(shop.getNin());

        ShopOwnerDto dtos = new ShopOwnerDto();

        ShopOwner shopOwners = shopOwnerReposiroty.findByLineIdNinIdShopId(lines, nin, shop1);
        if (shopOwners != null){
            return null;
        }
        Lga lga = lgaRepository.findFirstByNameIgnoreCase(nin.getResidenceLga());
        PortalUser portalUser = new PortalUser();
        UserDto dto = new UserDto();
        String tinNumber = tinGenerationService.generateNewTinNumber();
        User user1 = new User();
        Card card = new Card();
        Card card2 = new Card();
        Tin tin = new Tin();

        portalUser = portalUserRepository.findFirstByPhoneNumber(nin.getTelePhoneNumber());

        if (portalUser == null){
            dto.setEmail(nin.getNin());
            dto.setAddress(nin.getResidenceAddressLine1());
            dto.setFirstName(nin.getFirstName());
            dto.setLastName(nin.getSurname());
            dto.setPhoneNumber(nin.getTelePhoneNumber());
            dto.setPassword(tinNumber);
            dto.setRole("GENERAL_USER");
            if (lga != null){
                dto.setLga(lga.getId());
            }else{
                dto.setLga(74L);
            }

            Roles role = rolesRepository.findByNameIgnoreCase(dto.getRole()).orElseThrow(RuntimeException::new);
            portalUser = userManagementService.createUser(dto, jwtService.user, role);


            user1.setStatus(GenericStatusConstant.ACTIVE);
            user1.setPortalUser(portalUser);
            user1.setNin(nin);
            user1.setCreatedBy(jwtService.user);
            user1.setCreatedAt(LocalDateTime.now());
            user1.setTimeCreated(LocalDateTime.now());
            user1.setLastUpdatedAt(LocalDateTime.now());
            User createdUser = userRepository.save(user1);


            tin.setPortalUser(portalUser);
            tin.setTinType(TinType.INDIVIDUAL);
            tin.setTinNumber(tinGenerationService.generateNewTinNumber());
            tinRepository.save(tin);

            Card asinCard = new Card();

            asinCard.setTin(tinNumber);
            asinCard.setName(nin.getFirstName() + " " + nin.getSurname());
            asinCard.setPhoneNumber(nin.getTelePhoneNumber());
            asinCard.setPhoto(nin.getPhoto());
            asinCard.setCardType(CardType.ENUMERATION);
            asinCard.setCardStatus(CardStatus.NOT_PRINTED);
            asinCard.setStatus(GenericStatusConstant.ACTIVE);
            asinCard.setAddress(nin.getResidenceAddressLine1() + " " + nin.getResidenceLga());
            asinCard.setCreatedBy(jwtService.user);
            asinCard.setCreatedAt(LocalDateTime.now());
            asinCard.setLastUpdatedAt(LocalDateTime.now());
            cardRepository.save(asinCard);
        }


        tin.setPortalUser(portalUser);
        tin.setTinType(TinType.MARKET);
        tin.setTinNumber("M" + tinNumber);
        Tin createdTin = tinRepository.save(tin);

        ShopOwner owner = new ShopOwner();
        owner.setShop(shop1);
        owner.setLine(lines);
        owner.setNin(nin);
        owner.setPortalUser(portalUser);
        owner.setMarket(lines.getMarket());
        owner.setStatus(GenericStatusConstant.ACTIVE);
        owner.setCreatedAt(LocalDateTime.now());
        owner.setCreatedBy(jwtService.user);
        owner.setLastUpdatedAt(LocalDateTime.now());
        owner.setTin(createdTin);
        ShopOwner shopOwner = shopOwnerReposiroty.save(owner);

        card2.setTin(createdTin.getTinNumber());
        card2.setName(nin.getFirstName() + " " + nin.getSurname());
        card2.setPhoneNumber(nin.getTelePhoneNumber());
        card2.setPhoto(nin.getPhoto());
        card2.setCardType(CardType.MARKET);
        card2.setCardStatus(CardStatus.NOT_PRINTED);
        card2.setStatus(GenericStatusConstant.ACTIVE);
        card2.setAddress(nin.getResidenceAddressLine1() + " " + nin.getResidenceLga());
        card2.setCreatedBy(jwtService.user);
        card2.setCreatedAt(LocalDateTime.now());
        card2.setLastUpdatedAt(LocalDateTime.now());
        cardRepository.save(card2);

        card.setTin(createdTin.getTinNumber());
        card.setName(nin.getFirstName() + " " + nin.getSurname());
        card.setPhoneNumber(nin.getTelePhoneNumber());
        card.setPhoto(nin.getPhoto());
        card.setCardType(CardType.MARKET_STICKER);
        card.setCardStatus(CardStatus.NOT_PRINTED);
        card.setStatus(GenericStatusConstant.ACTIVE);
        card.setAddress(nin.getResidenceAddressLine1() + " " + nin.getResidenceLga());
        card.setCreatedBy(jwtService.user);
        card.setCreatedAt(LocalDateTime.now());
        card.setLastUpdatedAt(LocalDateTime.now());
        cardRepository.save(card);

        System.out.println(nin);
        System.out.println(portalUser);
        return dtos;
    }
}
