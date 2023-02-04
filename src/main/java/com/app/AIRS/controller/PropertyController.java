package com.app.AIRS.controller;

import com.app.AIRS.Utils.PredicateExtractor;
import com.app.AIRS.dto.PrintDto;
import com.app.AIRS.dto.PropertyPojo;
import com.app.AIRS.dto.filters.PropertySearchFilter;
import com.app.AIRS.entity.Property;
import com.app.AIRS.entity.QLga;
import com.app.AIRS.entity.QProperty;
import com.app.AIRS.entity.lgaArea.QLgaAreas;
import com.app.AIRS.repository.app.AppRepository;
import com.app.AIRS.service.PropertyService;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/property")
public class PropertyController {

    private final AppRepository appRepository;
    private final PredicateExtractor predicateExtractor;
    private final PropertyService propertyService;

    @GetMapping("/search")
    @Transactional
    public QueryResults<PropertyPojo> searchProperty(PropertySearchFilter filter) {

        JPAQuery<Property> propertyJPAQuery = appRepository.startJPAQuery(QProperty.property)
                .where(predicateExtractor.getPredicate(filter))
                .offset(filter.getOffset().orElse(0))
                .limit(filter.getLimit().orElse(10));

        if (filter.getLga() != null){
            propertyJPAQuery.where(QProperty.property.area.lgaId.eq(filter.getLga()));
        }

        OrderSpecifier<?> sortedColumn = appRepository.getSortedColumn(filter.getOrder().orElse(Order.DESC), filter.getOrderColumn().orElse("createdAt"), QProperty.property);
        QueryResults<Property> propertyQueryResults = propertyJPAQuery.select(QProperty.property).distinct().orderBy(sortedColumn).fetchResults();
        return new QueryResults<>(propertyService.get(propertyQueryResults.getResults()), propertyQueryResults.getLimit(), propertyQueryResults.getOffset(), propertyQueryResults.getTotal());
    }

    @PostMapping("/export")
    @Transactional
    public ResponseEntity<Resource> export(PropertySearchFilter filter, HttpServletRequest request) throws Exception {
        List<PropertyPojo> pojos = getPojo(filter);
        Resource resource = propertyService.exportProperties(pojos);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.error("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Property_list.xlsx")
                .body(resource);
    }

    private List<PropertyPojo>  getPojo(PropertySearchFilter filter) {

        JPAQuery<Property> propertyJPAQuery = appRepository.startJPAQuery(QProperty.property)
                .where(predicateExtractor.getPredicate(filter));

        if (filter.getLga() != null){
            propertyJPAQuery.where(QProperty.property.area.lgaId.eq(filter.getLga()));
        }

        OrderSpecifier<?> sortedColumn = appRepository.getSortedColumn(filter.getOrder().orElse(Order.DESC), filter.getOrderColumn().orElse("createdAt"), QProperty.property);
        QueryResults<Property> propertyQueryResults = propertyJPAQuery.select(QProperty.property).distinct().orderBy(sortedColumn).fetchResults();
        return propertyService.get(propertyQueryResults.getResults());
    }
}
