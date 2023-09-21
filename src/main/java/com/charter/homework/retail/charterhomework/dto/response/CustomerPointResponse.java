package com.charter.homework.retail.charterhomework.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class CustomerPointResponse {
  private String customerId;
  private int totalPoints;
  private Map<String, Integer> monthlyPoints;
}
