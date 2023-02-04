package com.app.AIRS.controller;


import com.app.AIRS.Utils.PredicateExtractor;
import com.app.AIRS.dto.SmsPojo;
import com.app.AIRS.dto.filters.SmsSearchFilter;
import com.app.AIRS.entity.QSms;
import com.app.AIRS.entity.Sms;
import com.app.AIRS.repository.app.AppRepository;
import com.app.AIRS.service.SmsService;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sms")
public class SmsTokenController {

    private final AppRepository appRepository;
    private final PredicateExtractor predicateExtractor;
    private final SmsService smsService;

    @GetMapping("/search")
    @Transactional
    public QueryResults<SmsPojo> searchSms(SmsSearchFilter filter){

        JPAQuery<Sms> smsJPAQuery = appRepository.startJPAQuery(QSms.sms)
                .where(predicateExtractor.getPredicate(filter))
                .offset(filter.getOffset().orElse(0))
                .limit(filter.getLimit().orElse(10));

        OrderSpecifier<?> sortedColumn = appRepository.getSortedColumn(filter.getOrder().orElse(Order.DESC), filter.getOrderColumn().orElse("createdAt"), QSms.sms);
        QueryResults<Sms> smsQueryResults = smsJPAQuery.select(QSms.sms).distinct().orderBy(sortedColumn).fetchResults();
        return new QueryResults<>(smsService.get(smsQueryResults.getResults()), smsQueryResults.getLimit(), smsQueryResults.getOffset(), smsQueryResults.getTotal());
    }

}
