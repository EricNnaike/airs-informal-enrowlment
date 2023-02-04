package com.app.AIRS.service;

import com.app.AIRS.dto.AsinDto;
import com.app.AIRS.dto.PropertyDto;
import com.app.AIRS.entity.*;
import com.app.AIRS.entity.lgaArea.LgaAreas;

import java.util.List;

public interface EnviromentService {

    List<State> AllStates();
    List<Lga> Alllga();

    List<Markets> findAllMarket();

    List<Lines> findLineByMarket(Long id);

    List<LgaAreas> findAreaByLga(Long id);

    List<TransportRoute> findRouteByList(Long id);

    List<Route> findAllTransport();

    List<Street> findStreetByArea(Long id);

    List<PropertyDto> findPropertyByStreet(Long id);

    List<Assessments> findAssessment();

    List<AssessmentTypes> findAssessmenttypeByAssessment(Long id);

    NIN findAllNinUser(Long id);

    AsinDto findAllAsinUser(Long id);

    List<Building_type> findProperty();

    List<Building_category> findPropertyByType(Long id);
}
