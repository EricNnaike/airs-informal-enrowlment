package com.app.AIRS.serviceImpl;

import com.app.AIRS.Utils.PDFRenderToMultiplePages;
import com.app.AIRS.dto.PropertyPojo;
import com.app.AIRS.entity.Property;
import com.app.AIRS.repository.LgaRepository;
import com.app.AIRS.repository.OccupantRepository;
import com.app.AIRS.service.PropertyService;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private static final int SN = 1;
    private static final int HOUSE_NO = 2;
    private static final int CATEGORY = 3;
    private static final int TYPE = 4;
    private static final int LGA = 5;
    private static final int AREA = 6;
    private static final int STREET = 7;
    private static final int PID = 8;
    private static final int DATE_CREATED = 9;
    private static final int NO_OF_APARTMENTS = 10;
    private static final int NO_OF_OCCUPANTS= 11;

    private final LgaRepository lgaRepository;
    private final OccupantRepository occupantRepository;
    private final PDFRenderToMultiplePages pdfRenderToMultiplePages;

    @Override
    public List<PropertyPojo> get(List<Property> properties) {

       return properties.stream().map(property -> {
            PropertyPojo pojo = new PropertyPojo();
            pojo.setStreet(property.getStreet().getName());
            pojo.setHouseNumber(property.getHouseNumber());
            pojo.setCategory(property.getCategory().getName());
            pojo.setLga(lgaRepository.findById(property.getArea().getLgaId()).get().getName());
            pojo.setArea(property.getArea().getName());
            pojo.setType(property.getType().getName());
            pojo.setPid(property.getPid());
            pojo.setApartments(property.getApartment());
            pojo.setOccupants(occupantRepository.findAllByPropertyId(property.getId()).size());
            pojo.setDateCreated(property.getCreatedAt().toLocalDate());

            return pojo;
        }).collect(Collectors.toList());
    }

    @Override
    public Resource exportProperties(List<PropertyPojo> pojos) throws IOException {
        String uploadTemplatePath = "/excel/Property_list.xlsx";
        InputStream inputStream = getClass().getResourceAsStream(uploadTemplatePath);
        if (inputStream == null) throw new IllegalArgumentException("File not found");

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd - MMM - yyyy");

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("sheet1");
        int firstRow = sheet.getFirstRowNum() + 2;
        Cell cell = null;
        Row row = null;

        for (PropertyPojo propertyPojo: pojos){
            row = sheet.createRow(firstRow++);
            int columnNumber = 0;
            for (int i = 0; i<=10; i++){
                cell = row.createCell(columnNumber++);
                switch (columnNumber){
                    case SN:
                        cell.setCellValue(row.getRowNum() - 1);
                        break;
                    case HOUSE_NO:
                        cell.setCellValue(propertyPojo.getHouseNumber());
                        break;
                    case CATEGORY:
                        cell.setCellValue(propertyPojo.getCategory());
                        break;
                    case TYPE:
                        cell.setCellValue(propertyPojo.getType());
                        break;
                    case LGA:
                        cell.setCellValue(propertyPojo.getLga());
                        break;
                    case AREA:
                        cell.setCellValue(propertyPojo.getArea());
                        break;
                    case STREET:
                        cell.setCellValue(propertyPojo.getStreet());
                        break;
                    case PID:
                        cell.setCellValue(propertyPojo.getPid());
                        break;
                    case DATE_CREATED:
                        cell.setCellValue(propertyPojo.getDateCreated().format(df));
                        break;
                    case NO_OF_APARTMENTS:
                        cell.setCellValue(propertyPojo.getApartments());
                        break;
                    case NO_OF_OCCUPANTS:
                        cell.setCellValue(propertyPojo.getOccupants());
                        break;
                }
            }
        }
        return pdfRenderToMultiplePages.loadFileAsResource(pdfRenderToMultiplePages.createDirectory(workbook));
    }


}
