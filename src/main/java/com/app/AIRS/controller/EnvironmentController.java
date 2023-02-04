package com.app.AIRS.controller;

import com.app.AIRS.dto.AsinDto;
import com.app.AIRS.dto.PropertyDto;
import com.app.AIRS.entity.*;
import com.app.AIRS.entity.lgaArea.LgaAreas;
import com.app.AIRS.service.EnviromentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/environment")
public class EnvironmentController {

    @Autowired
    EnviromentService environmentService;


    @GetMapping("/all/state")
    public List<State> AllStates(){
        return environmentService.AllStates();
    }
    @GetMapping("/all/lga")
    public List<Lga> Alllga(){
        return environmentService.Alllga();
    }
    @GetMapping("/all/market")
    public List<Markets> AllMarket(){
        return environmentService.findAllMarket();
    }
    @GetMapping("/all/line/{id}")
    public List<Lines> AllMarket(@PathVariable Long id){
        return environmentService.findLineByMarket(id);
    }
    @GetMapping("/all/area/{id}")
    public List<LgaAreas> AllAreaByLga(@PathVariable Long id){
        return environmentService.findAreaByLga(id);
    }
    @GetMapping("/all/street/{id}")
    public List<Street> AllStreetByArea(@PathVariable Long id){
        return environmentService.findStreetByArea(id);
    }


    @GetMapping("/all/transport/route/{id}")
    public List<TransportRoute> AllRouteByList(@PathVariable Long id){
        return environmentService.findRouteByList(id);
    }
    @GetMapping("/all/transport")
    public List<Route> AllTransport(){
        return environmentService.findAllTransport();
    }

    @GetMapping("/all/building/property/{id}")
    public List<PropertyDto> AllPropertyByStreet(@PathVariable Long id){
        return environmentService.findPropertyByStreet(id);
    }

    @GetMapping("/all/building/category/{id}")
    public List<Building_category> AllBuildingByType(@PathVariable Long id){
        return environmentService.findPropertyByType(id);
    }

    @GetMapping("/all/building/type")
    public List<Building_type> AllProperty(){
        return environmentService.findProperty();
    }

    @GetMapping("/all/building/assessment")
    public List<Assessments> AllAssessment(){
        return environmentService.findAssessment();
    }

    @GetMapping("/all/building/assessmenttype/{id}")
    public List<AssessmentTypes> AllAssessmenttypeByAssessment(@PathVariable Long id){
        return environmentService.findAssessmenttypeByAssessment(id);
    }

    @GetMapping("/all/ninuser/{id}")
    public NIN AllNinUser(@PathVariable Long id){
        return environmentService.findAllNinUser(id);
    }

    @GetMapping("/all/asinuser/{id}")
    public AsinDto AllAsinUser(@PathVariable Long id){
        return environmentService.findAllAsinUser(id);
    }


}
