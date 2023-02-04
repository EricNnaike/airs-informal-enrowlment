package com.app.AIRS.serviceImpl;

import com.app.AIRS.dto.SmsPojo;
import com.app.AIRS.entity.Sms;
import com.app.AIRS.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SmsServiceImpl implements SmsService {
    @Override
    public List<SmsPojo> get(List<Sms> smsList) {
       return smsList.stream().map(sms -> {
           SmsPojo pojo = new SmsPojo();
           pojo.setPhoneNumber(sms.getPhoneNumber());
           pojo.setToken(sms.getToken());
           pojo.setUsed(sms.getUsed());
           pojo.setCreatedAt(sms.getCreatedAt().toLocalDate());

           return pojo;
       }).collect(Collectors.toList());
    }
}
