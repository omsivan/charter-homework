package com.charter.homework.retail.charterhomework.dto.request;

import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@NoArgsConstructor(force = true)
public class CustomerPurchaseRewardPointRequest {
  List<CustomerPurchase> customerPurchases;
}
