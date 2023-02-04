package com.app.AIRS.dto;

import com.app.AIRS.Enum.PaymentStatus;
import lombok.Data;

@Data
public class NotificationDto {
    private String asin;
    private PaymentStatus status;
}
