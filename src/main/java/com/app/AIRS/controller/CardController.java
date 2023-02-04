package com.app.AIRS.controller;


import com.app.AIRS.Enum.CardStatus;
import com.app.AIRS.Enum.PaymentStatus;
import com.app.AIRS.Utils.PredicateExtractor;
import com.app.AIRS.dto.CardDto;
import com.app.AIRS.dto.NotificationDto;
import com.app.AIRS.dto.PrintDto;
import com.app.AIRS.dto.filters.CardSearchFilter;
import com.app.AIRS.entity.Card;
import com.app.AIRS.entity.QCard;
import com.app.AIRS.repository.app.AppRepository;
import com.app.AIRS.service.CardService;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CardController {

    private final CardService cardService;
    private final AppRepository appRepository;
    private final PredicateExtractor predicateExtractor;

    @GetMapping("/card/search")
    @Transactional
    public QueryResults<CardDto> searchCards(CardSearchFilter filter){

        JPAQuery<Card> cardJPAQuery = appRepository.startJPAQuery(QCard.card)
                .where(predicateExtractor.getPredicate(filter))
                .where(QCard.card.cardStatus.ne(CardStatus.NOT_PAID))
                .offset(filter.getOffset().orElse(0))
                .limit(filter.getLimit().orElse(10));

        if (filter.getCreatedAfter() != null){
            cardJPAQuery.where(QCard.card.createdAt.goe(filter.getCreatedAfter().atStartOfDay()));
        }

        if (filter.getCreatedBefore() != null){
            cardJPAQuery.where(QCard.card.createdAt.loe(filter.getCreatedBefore().atTime(LocalTime.MAX)));
        }

        OrderSpecifier<?> sortedColumn = appRepository.getSortedColumn(filter.getOrder().orElse(Order.DESC), filter.getOrderColumn().orElse("createdAt"), QCard.card);
        QueryResults<Card> cardQueryResults = cardJPAQuery.select(QCard.card).distinct().orderBy(sortedColumn).fetchResults();
        return new QueryResults<>(cardService.get(cardQueryResults.getResults()), cardQueryResults.getLimit(), cardQueryResults.getOffset(), cardQueryResults.getTotal());
    }

    @PostMapping("/card/print")
    @Transactional
    public ResponseEntity<Resource> printCard(@RequestBody List<PrintDto> dtos, HttpServletRequest request) throws Exception {
        Resource resource = cardService.printCard(dtos);
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            log.error("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/pdf";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=card.pdf")
                .body(resource);
    }

    @PostMapping("/card/update")
    @Transactional
    public ResponseEntity<?> updateCardPaymentStatus(@RequestBody NotificationDto dto){
        if(dto.getStatus().equals(PaymentStatus.APPROVED)){
            cardService.updateCardStatus(dto.getAsin());
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/card/search-unpaid")
    @Transactional
    public QueryResults<CardDto> searchUnpaidCards(CardSearchFilter filter){

        JPAQuery<Card> cardJPAQuery = appRepository.startJPAQuery(QCard.card)
                .where(predicateExtractor.getPredicate(filter))
                .where(QCard.card.cardStatus.eq(CardStatus.NOT_PAID))
                .offset(filter.getOffset().orElse(0))
                .limit(filter.getLimit().orElse(10));

        if (filter.getCreatedAfter() != null){
            cardJPAQuery.where(QCard.card.createdAt.goe(filter.getCreatedAfter().atStartOfDay()));
        }

        if (filter.getCreatedBefore() != null){
            cardJPAQuery.where(QCard.card.createdAt.loe(filter.getCreatedBefore().atTime(LocalTime.MAX)));
        }

        OrderSpecifier<?> sortedColumn = appRepository.getSortedColumn(filter.getOrder().orElse(Order.DESC), filter.getOrderColumn().orElse("createdAt"), QCard.card);
        QueryResults<Card> cardQueryResults = cardJPAQuery.select(QCard.card).distinct().orderBy(sortedColumn).fetchResults();
        return new QueryResults<>(cardService.get(cardQueryResults.getResults()), cardQueryResults.getLimit(), cardQueryResults.getOffset(), cardQueryResults.getTotal());
    }
}
