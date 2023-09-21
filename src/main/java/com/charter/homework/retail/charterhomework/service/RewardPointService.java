package com.charter.homework.retail.charterhomework.service;

import com.charter.homework.retail.charterhomework.dto.request.CustomerPurchase;
import com.charter.homework.retail.charterhomework.dto.request.CustomerPurchaseRewardPointRequest;
import com.charter.homework.retail.charterhomework.dto.response.CustomerPointResponse;
import com.charter.homework.retail.charterhomework.dto.response.RewardsResponse;
import com.charter.homework.retail.charterhomework.exceptions.CustomerIdNotProvidedException;
import com.charter.homework.retail.charterhomework.exceptions.DateTimeNotProvidedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Service
public class RewardPointService {
  private final RetailerRewardPointsCalculator retailerRewardPointsCalculator;

  @Autowired
  public RewardPointService(RetailerRewardPointsCalculator retailerRewardPointsCalculator) {
    this.retailerRewardPointsCalculator = retailerRewardPointsCalculator;
  }

  /**
   * Calculates the reward points earned for each customer per month and total.
   *
   * @param customerPurchaseRewardPointRequest the Request Body.
   * @return the reward points earned for each customer per month and total.
   */
  public RewardsResponse calculateRewardsPointsWithStreams(CustomerPurchaseRewardPointRequest customerPurchaseRewardPointRequest) {
    final Map<String, Integer> customerTotalPointsMap =
            customerPurchaseRewardPointRequest.getCustomerPurchases()
                                              .stream()
                                              .collect(groupingBy(e -> {
                                                        if (e.getCustomerId() == null) {
                                                          throw new CustomerIdNotProvidedException();
                                                        }
                                                        return e.getCustomerId();
                                                      },
                                                      summingInt(e ->
                                                              retailerRewardPointsCalculator.calculate(e.getAmount()))));

    final Map<String, Map<String, Integer>> customerMonthlyPointsMap =
            customerPurchaseRewardPointRequest.getCustomerPurchases()
                                              .stream()
                                              .collect(groupingBy(CustomerPurchase::getCustomerId,
                                                      groupingBy(e1 -> {
                                                                if (e1.getDateTime() == null) {
                                                                  throw new DateTimeNotProvidedException();
                                                                }
                                                                return e1.getDateTime()
                                                                         .getMonth()
                                                                         .getDisplayName(TextStyle.FULL, Locale.US);
                                                              },
                                                              summingInt(e2 ->
                                                                      retailerRewardPointsCalculator.calculate(e2.getAmount())))));


    List<CustomerPointResponse> customerPointResponses = new ArrayList<>();

    customerTotalPointsMap.forEach((k, v) -> customerPointResponses.add(
            CustomerPointResponse.builder()
                                 .customerId(k)
                                 .totalPoints(v)
                                 .monthlyPoints(customerMonthlyPointsMap.get(k))
                                 .build()));

    return RewardsResponse.builder()
                          .customerPointResponses(customerPointResponses)
                          .build();
  }
}
