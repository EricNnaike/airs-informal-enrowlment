package com.app.AIRS.serviceImpl;

import com.app.AIRS.Enum.TinType;
import com.app.AIRS.dto.AsinDto;
import com.app.AIRS.dto.PropertyDto;
import com.app.AIRS.entity.*;
import com.app.AIRS.entity.lgaArea.LgaAreas;
import com.app.AIRS.repository.*;
import com.app.AIRS.service.EnviromentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnvironmentServiceImpl implements EnviromentService {
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private LgaRepository lgaRepository;
    @Autowired
    private MarketRepository marketRepository;
    @Autowired
    private LineRepository lineRepository;
    @Autowired
    private LgaAreaRepository lgaAreaRepository;
    @Autowired
    private TransportRouteRepository transportRouteRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StreetRepository streetRepository;
    @Autowired
    private BuildingCategoryRepository buildingCategoryRepository;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private AssessmentRepository assessmentRepository;
    @Autowired
    private AssessmentTypeRepository assessmentTypeRepository;
    @Autowired
    private NinRepository ninRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TinRepository tinRepository;
    @Autowired
    private BuildingTypeRepository buildingTypeRepository;


    public List<State> AllStates() {
        return  stateRepository.findAll();
    }

    public List<Lga> Alllga() {
        return lgaRepository.findAllByStateId();
    }

    @Override
    public List<Markets> findAllMarket() {
        return marketRepository.findAll();
    }

    @Override
    public List<Lines> findLineByMarket(Long id) {
        return lineRepository.findAllByMarket(id);
    }

    @Override
    public List<LgaAreas> findAreaByLga(Long id) {
        return lgaAreaRepository.findByLgaId(id);
    }

    @Override
    public List<TransportRoute> findRouteByList(Long id) {
        return transportRouteRepository.findByTransport(id);
    }

    @Override
    public List<Route> findAllTransport() {
        return routeRepository.findAll();
    }

    @Override
    public List<Street> findStreetByArea(Long id) {
        return streetRepository.findByArea(id);
    }

    @Override
    public List<PropertyDto> findPropertyByStreet(Long id) {
        Street street = streetRepository.findById(id).get();
        List<Property> property = propertyRepository.findAllByStreet(street);

        List<PropertyDto> propertyDto = new ArrayList<>();
        property.forEach(emp->{
            Building_type type = buildingTypeRepository.findById(emp.getType().getId()).get();
            PropertyDto dto = new PropertyDto();
            dto.setStreetName(street.getName());
            dto.setCategory(type.getName());
            dto.setHouseNumber(emp.getHouseNumber());
            dto.setId(emp.getId());
            dto.setPid(emp.getPid());

            propertyDto.add(dto);
        });

        return propertyDto;
    }

    @Override
    public List<Assessments> findAssessment() {
        return assessmentRepository.findAll();
    }

    @Override
    public List<AssessmentTypes> findAssessmenttypeByAssessment(Long id) {
        return assessmentTypeRepository.findByAssessments(id);
    }

    @Override
    public NIN findAllNinUser(Long id) {
        return ninRepository.findById(id).get();
    }

    @Override
    public AsinDto findAllAsinUser(Long id) {
        AsinDto dto = new AsinDto();

        User user = userRepository.findById(id).get();
        NIN nin = ninRepository.findByNin(user.getNin().getNin());
        Tin tin = tinRepository.findFirstByPortalUser(user.getPortalUser());
        dto.setName(nin.getFirstName() + " " + nin.getSurname() + " " + nin.getMiddleName());
        dto.setPhoto(nin.getPhoto());
        dto.setPhoneNumber(nin.getTelePhoneNumber());
        dto.setAddress("No " + user.getHouseNumber() +" "  + nin.getResidenceAddressLine1() + " " + nin.getResidenceLga());
        dto.setLandMark(user.getLandmark());
        dto.setAsin(tin.getTinNumber());



        return dto;
    }

    @Override
    public List<Building_type> findProperty() {
        return buildingTypeRepository.findAll();
    }

    @Override
    public List<Building_category> findPropertyByType(Long id) {
        return buildingCategoryRepository.findAllByType(id);
    }


}
