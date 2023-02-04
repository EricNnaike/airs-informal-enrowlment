package com.app.AIRS.dto;

import com.app.AIRS.entity.Card;
import lombok.Data;

import java.util.Map;

@Data
public class PdfPojo {
    private String templateName;
    private Card card;
    private Map<String, Object> extraParameter;
}
