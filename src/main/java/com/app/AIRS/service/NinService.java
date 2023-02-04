package com.app.AIRS.service;

import com.app.AIRS.entity.NIN;
import com.app.AIRS.nin.search_by_nin.FindByNinDataResponsePojo;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public interface NinService {

    NIN findByNIN(String nin);

    NIN findByPhoneNumber(String phoneNumber);

    NIN save(FindByNinDataResponsePojo findByNinDataResponsePojo,
             String photoURL,
    String signatureURL,
    String fileCodeForPhoto,
    String fileCodeForSignature) throws ParseException;

    NIN saves(FindByNinDataResponsePojo findByNinDataResponsePojo) throws ParseException;
}
