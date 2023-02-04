package com.app.AIRS.service;

import com.app.AIRS.dto.ReportDto;
import com.app.AIRS.entity.Property;
import com.app.AIRS.entity.Transport;

import java.util.List;

public interface ReportInterface {

    List<Transport> getAllTransportUser();

    List<Property> getAllProperty();

    ReportDto getAllReport();
}
