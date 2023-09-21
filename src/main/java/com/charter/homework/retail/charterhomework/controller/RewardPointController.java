package com.charter.homework.retail.charterhomework.controller;

import com.charter.homework.retail.charterhomework.dto.request.CustomerPurchaseRewardPointRequest;
import com.charter.homework.retail.charterhomework.dto.response.RewardsResponse;
import com.charter.homework.retail.charterhomework.exceptions.AmountNotProvidedException;
import com.charter.homework.retail.charterhomework.exceptions.CustomerIdNotProvidedException;
import com.charter.homework.retail.charterhomework.exceptions.DateTimeNotProvidedException;
import com.charter.homework.retail.charterhomework.service.RewardPointService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class RewardPointController {

  private final RewardPointService rewardPointService;

  @Autowired
  public RewardPointController(RewardPointService rewardPointService) {
    this.rewardPointService = rewardPointService;
  }

  /**
   * Calculates the reward points earned for each customer per month and total.
   *
   * @param customerPurchaseRewardPointRequest the Request Body.
   * @return the reward points earned for each customer per month and total.
   */
  @GetMapping("/reward-points")
  public RewardsResponse calculateRewardsPointsWithStreams(
          @Valid @RequestBody CustomerPurchaseRewardPointRequest customerPurchaseRewardPointRequest) {
    try {
      return rewardPointService.calculateRewardsPointsWithStreams(customerPurchaseRewardPointRequest);
    } catch (AmountNotProvidedException | CustomerIdNotProvidedException | DateTimeNotProvidedException e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    }
  }
}