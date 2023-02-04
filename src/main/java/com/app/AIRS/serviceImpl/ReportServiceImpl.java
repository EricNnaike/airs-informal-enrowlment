package com.app.AIRS.serviceImpl;

import com.app.AIRS.Utils.PredicateExtractor;
import com.app.AIRS.dto.ReportDto;
import com.app.AIRS.entity.Property;
import com.app.AIRS.entity.Transport;
import com.app.AIRS.entity.userManagement.PortalUser;
import com.app.AIRS.repository.*;
import com.app.AIRS.repository.app.AppRepository;
import com.app.AIRS.security.JwtService;
import com.app.AIRS.service.ReportInterface;
import com.app.AIRS.service.UserManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportInterface {

    private final UserManagementService userManagementService;
    private final RolesRepository rolesRepository;
    private final AppRepository appRepository;
    private final PredicateExtractor predicateExtractor;
    private final JwtService jwtService;
    private final PortalUserRepository portalUserRepository;

    @Autowired
    private ShopRepository marketUserRepository;
    @Autowired
    private TransportRepository transportUserRepository;
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Transport> getAllTransportUser() {
        return transportUserRepository.findAll();
    }

    @Override
    public List<Property> getAllProperty() {
        return propertyRepository.findAll();
    }

    @Override
    public ReportDto getAllReport() {
        PortalUser user = jwtService.user;
        ReportDto dto = new ReportDto();

//        int market = marketUserRepository.findAllByCreatedBy(user).size();
        int transports = transportUserRepository.findAllByCreatedBy(user).size();
        int properties = propertyRepository.findAllByCreatedBy(user).size();
        int users = userRepository.findAllByCreatedBy(user).size();

        dto.setAsin(users);
//        dto.setMarket(market);
        dto.setProperty(properties);
        dto.setTransport(transports);
        dto.setUsername(user.getDisplayName());
        dto.setImage(user.getImage());

        return dto;
    }
}
