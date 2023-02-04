package com.app.AIRS.controller;

import com.app.AIRS.dto.*;
import com.app.AIRS.entity.*;
import com.app.AIRS.repository.*;
import com.app.AIRS.service.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UtilityController {

    @Autowired
    private TinRepository mTinRepository;
    @Autowired
    private UserDemographyIndividualRepository userDemographyIndividualRepository;
    @Autowired
    private UserDemographyCorperateRepository userDemographyCorperateRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserGroupRepository mTaxGroupRepository;
    @Autowired
    private LgaAreaRepository lgaAreaRepository;
    @Autowired
    private LgaRepository lgaRepository;
    @Autowired
    UtilityService utilityService;

    @PostMapping("/save/market/all")
    public ShopDto saveShop(@RequestBody Shop shop){
        return utilityService.saveShop(shop);
    }

    @PostMapping("/save/shopowner")
    public ShopOwnerDto saveMarket(@RequestBody ShopOwnerDto shop){
        return utilityService.saveShopOwner(shop);
    }

    @PostMapping("/get/shopoccupants")
    private List<ShopOwnerDto> GetUser(@RequestBody ShopDto shopDto){
        return utilityService.getUser(shopDto);
    }

    @GetMapping(path = "/home")
    public String validateTin() {
        return "Welcome to this portal";
    }

    @PostMapping("/save/transport")
    public Long saveTransport(@RequestBody TransportDto transportDto){
        return utilityService.saveTransport(transportDto);
    }

    @GetMapping("/get/registeredtransportuser/{id}")
    private TransportDto GetTransportUser(@PathVariable Long id){
        return utilityService.getTransportUser(id);
    }

    @GetMapping("/get/registereddriveruser/{id}")
    private DriverDto GetDriverUser(@PathVariable Long id){
        return utilityService.getDriverUser(id);
    }


    @PostMapping("/save/street")
    public Long saveStreet(@RequestBody Street street){
        return utilityService.saveStreet(street);
    }


    @PostMapping("/save/property")
    public Long saveProperty(@RequestBody PropertyDto property){
        return utilityService.saveProperty(property);
    }

    @PostMapping("/save/occupant")
    public Long saveOccupant(@RequestBody Occupant occupant){
        return utilityService.saveOccupant(occupant);
    }

    @PostMapping("/save/driver")
    public Long saveDriver(@RequestBody DriverDto transportDriverUser){
        return utilityService.saveDriver(transportDriverUser);
    }

    @PostMapping("/save/forasin")
    public Long saveAsin(@RequestBody AsinDto asinDto){
        return utilityService.saveForAsin(asinDto);
    }

    @GetMapping("/get/nin/sms/{id}")
    public SmsDto GetNinForSms(@PathVariable Long id){
        return utilityService.getNinForSms(id);
    }

    @GetMapping("/get/corperate/sms/{phoneNumber}")
    public SmsDto GetCorperateForSms(@PathVariable String phoneNumber){
        return utilityService.getCorperateForSms(phoneNumber);
    }

    @GetMapping("/get/version")
    public VersionDto GetVersion(){
        return utilityService.getVersion();
    }

    @PostMapping("/get/phone/sms")
    public PhoneDto GetPhoneNumberForSms(@RequestBody PhoneDto phone){
        return utilityService.getPhoneNumberForSms(phone);
    }

    @GetMapping("/get/business/type")
    public List<BusinessType> GetBusinesstype(){
        return utilityService.getBusinessType();
    }

    @GetMapping("/get/business/classification/{id}")
    public List<BusinessClassification> GetBusinessClassification(@PathVariable Long id){
        return utilityService.getBusinessClassification(id);
    }

    @PostMapping("/save/corperate/all")
    public CorperateDto saveCorperateUser(@RequestBody Corperate user){
        return utilityService.saveCorperate(user);
    }


    @PostMapping("/search/user")
    public List<AsinDto> saveCorperateUser(@RequestBody SearchDto user){
        return utilityService.searchUser(user);
    }

}
