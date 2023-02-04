package com.app.AIRS.service;

import com.app.AIRS.dto.PropertyPojo;
import com.app.AIRS.entity.Property;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

public interface PropertyService {

    List<PropertyPojo> get(List<Property> properties);

    Resource exportProperties(List<PropertyPojo> pojos) throws IOException;
}
