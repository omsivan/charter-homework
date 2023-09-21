package com.charter.homework.retail.charterhomework.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Value
@NoArgsConstructor(force = true)
public class CustomerPurchase {
  String customerId;
  BigDecimal amount;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  LocalDateTime dateTime;
}
