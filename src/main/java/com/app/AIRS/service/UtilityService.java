package com.app.AIRS.service;


import com.app.AIRS.dto.*;
import com.app.AIRS.entity.*;

import java.util.List;

public interface UtilityService {
    ShopDto saveShop(Shop shop);

    List<ShopOwnerDto> getUser(ShopDto shopDto);

    Long saveTransport(TransportDto transportDto);

    TransportDto getTransportUser(Long id);

    Long saveStreet(Street street);

    Long saveProperty(PropertyDto property);

    Long saveOccupant(Occupant occupant);

    Long saveDriver(DriverDto transportDriverUser);

    DriverDto getDriverUser(Long id);

    SmsDto getNinForSms(Long id);

    VersionDto getVersion();

    Long saveForAsin(AsinDto asinDto);

    PhoneDto getPhoneNumberForSms(PhoneDto phone);

    List<BusinessType> getBusinessType();

    List<BusinessClassification> getBusinessClassification(Long id);

    CorperateDto saveCorperate(Corperate user);

    List<AsinDto> searchUser(SearchDto user);

    SmsDto getCorperateForSms(String phoneNumber);

    ShopOwnerDto saveShopOwner(ShopOwnerDto shop);
}
