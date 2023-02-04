package com.app.AIRS.service;

import com.app.AIRS.dto.CardDto;
import com.app.AIRS.dto.PrintDto;
import com.app.AIRS.entity.Card;
import org.springframework.core.io.Resource;

import java.util.List;

public interface CardService {
    List<CardDto> get(List<Card> cards);

    Resource printCard(List<PrintDto> dtos) throws Exception;

    void updateCardStatus(String asin);
}
