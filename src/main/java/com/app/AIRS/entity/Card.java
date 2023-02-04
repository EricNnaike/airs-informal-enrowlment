package com.app.AIRS.entity;

import com.app.AIRS.Enum.CardStatus;
import com.app.AIRS.Enum.CardType;
import com.app.AIRS.entity.userManagement.StatusEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CARD")
public class Card  extends StatusEntity {

    private String Name;
    private String phoneNumber;
    private String address;
    private String plateNumber;
    private String marketLine;
    private String tin;
    private String photo;
    private String route;
    private String qrcode;
    private String type;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    private CardStatus cardStatus;

}
