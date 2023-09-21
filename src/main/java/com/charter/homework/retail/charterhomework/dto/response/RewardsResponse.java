package com.charter.homework.retail.charterhomework.dto.response;

import com.charter.homework.retail.charterhomework.dto.response.CustomerPointResponse;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class RewardsResponse {
  private List<CustomerPointResponse> customerPointResponses;
}
