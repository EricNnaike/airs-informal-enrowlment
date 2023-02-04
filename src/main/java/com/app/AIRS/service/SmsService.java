package com.app.AIRS.service;


import com.app.AIRS.dto.SmsPojo;
import com.app.AIRS.entity.Sms;

import java.util.List;

public interface SmsService {
    List<SmsPojo> get(List<Sms> smsList);
}
