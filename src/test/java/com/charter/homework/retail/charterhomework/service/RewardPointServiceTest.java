package com.charter.homework.retail.charterhomework.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class RewardPointServiceTest {


  private RewardPointService rewardPointService;

  @Test
  void calculateRewardsPointsStreamsTest(){
    RetailerRewardPointsCalculator retailerRewardPointsCalculator = new RetailerRewardPointsCalculator();
    rewardPointService = new RewardPointService(retailerRewardPointsCalculator);

//    rewardPointService.calculateRewardsPointsStreams()
  }

}