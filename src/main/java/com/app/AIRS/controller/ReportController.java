package com.app.AIRS.controller;

import com.app.AIRS.dto.ReportDto;
import com.app.AIRS.entity.*;
import com.app.AIRS.service.ReportInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    ReportInterface reportInterface;

    @GetMapping(path = "/report/all/report")
    public ReportDto AllReport() {
        return reportInterface.getAllReport();
    }

    @GetMapping(path = "/report/all/transport")
    public List<Transport> Alltransport() {
        return reportInterface.getAllTransportUser();
    }

    @GetMapping(path = "/report/all/property")
    public List<Property> AllProperty() {
        return reportInterface.getAllProperty();
    }

}
