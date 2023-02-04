package com.app.AIRS.dto;

import com.app.AIRS.Enum.CardStatus;
import com.app.AIRS.Enum.CardType;
import lombok.Data;
import java.time.LocalDate;

@Data
public class CardDto {
    private Long id;
    private String name;
    private String tin;
    private LocalDate dateCreated;
    private CardStatus status;
    private CardType type;
}
