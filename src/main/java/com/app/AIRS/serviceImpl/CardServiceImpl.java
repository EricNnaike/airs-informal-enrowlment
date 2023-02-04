package com.app.AIRS.serviceImpl;


import com.app.AIRS.Enum.CardStatus;
import com.app.AIRS.Enum.CardType;
import com.app.AIRS.Utils.HtmlToPdfCreator;
import com.app.AIRS.Utils.PDFRenderToMultiplePages;
import com.app.AIRS.configuration.AppConfigurationProperties;
import com.app.AIRS.dto.CardDto;
import com.app.AIRS.dto.PdfPojo;
import com.app.AIRS.dto.PrintDto;
import com.app.AIRS.entity.Card;
import com.app.AIRS.repository.CardRepository;
import com.app.AIRS.service.CardService;
import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 * @author uhuegbulem chinomso
 * email: chimaisaac60@gmail.com
 * Oct, 2022
 **/


@Slf4j
@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {
    private final CardRepository cardRepository;
    private final HtmlToPdfCreator htmlToPdfCreator;
    private final PDFRenderToMultiplePages pdfRenderToMultiplePages;
    private final AppConfigurationProperties appConfigurationProperties;

    @Override
    public List<CardDto> get(List<Card> cards) {
        return cards.stream().map(card -> {
            CardDto dto = new CardDto();
            dto.setId(card.getId());
            dto.setName(card.getName());
            dto.setTin(card.getTin());
            dto.setDateCreated(card.getCreatedAt().toLocalDate());
            dto.setStatus(card.getCardStatus());
            dto.setType(card.getCardType());
            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Resource printCard(List<PrintDto> dtos) throws Exception {
        List<PdfPojo> pdfPojos = dtos.stream().map(dto -> {
           Card card = cardRepository.findById(dto.getId()).orElseThrow(RuntimeException::new);

           Map<String, Object> extraParameter = new TreeMap<>();

           String templateName = getTemplate(dto.getType());

           DateTimeFormatter df = DateTimeFormatter.ofPattern("dd - MMM - yyyy");

           extraParameter.put("photo", card.getPhoto());
           extraParameter.put("asin", card.getTin());
           extraParameter.put("name", card.getName());
           extraParameter.put("address", card.getAddress());
           extraParameter.put("phoneNumber", card.getPhoneNumber());
           extraParameter.put("dateCreated", card.getCreatedAt().format(df));
           extraParameter.put("barcode", card.getQrcode());
           extraParameter.put("line", card.getMarketLine());
           extraParameter.put("shop", card.getPlateNumber());
           extraParameter.put("route", card.getRoute());
           extraParameter.put("item", card.getType());

           PdfPojo pojo = new PdfPojo();
           pojo.setTemplateName(templateName);
           pojo.setExtraParameter(extraParameter);
           pojo.setCard(card);

            if(card.getCardStatus() != CardStatus.PRINTED){
                card.setCardStatus(CardStatus.PRINTED);
                card.setLastUpdatedAt(LocalDateTime.now());

                cardRepository.save(card);
            }

           return pojo;

       }).collect(Collectors.toList());

       List<String> templates = new ArrayList();

       pdfPojos.forEach(pdfPojo -> {
           try {
               templates.add(htmlToPdfCreator.createPDFString(pdfPojo.getTemplateName(), htmlToPdfCreator.getContext(pdfPojo.getCard(), pdfPojo.getExtraParameter())));
           } catch (IllegalAccessException | IOException | DocumentException e) {
               e.printStackTrace();
           }
       });

      String fileName = pdfRenderToMultiplePages.multiPage(templates);

        if (StringUtils.isBlank(fileName)) {
            throw new Exception("file not found");
        }

        return pdfRenderToMultiplePages.loadFileAsResource(appConfigurationProperties.getPrintDirectory() +"/"+ fileName);
    }

    @Override
    public void updateCardStatus(String asin) {
       List<Card> cards = cardRepository.findByTin(asin);

       cards.forEach(card -> {
           card.setCardStatus(CardStatus.NOT_PRINTED);
           card.setLastUpdatedAt(LocalDateTime.now());
           cardRepository.save(card);
       });
    }

    private String getTemplate(CardType type){
        String templateName = "";

        switch (type) {
            case ENUMERATION:
                return templateName = "asin-card";
            case MARKET:
                return templateName = "market-card";
            case TRANSPORT:
                return  templateName = "transport-card";
            case MARKET_STICKER:
                return templateName = "market-sticker";
            case TRANSPORT_STICKER:
                return templateName = "transport-sticker";

            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
