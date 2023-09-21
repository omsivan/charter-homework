package com.charter.homework.retail.charterhomework.service;

import com.charter.homework.retail.charterhomework.exceptions.AmountNotProvidedException;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class RetailerRewardPointsCalculator {

  /**
   * A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar
   * spent between $50 and $100 in each transaction. (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
   * <p>
   * The above rewards strategy is mathematically is same as follows:
   * <p>
   * x | x <= 50 then y = 0;
   * <p>
   * x | 50 < x <= 100 then y = x -50;
   * <p>
   * x | x > 100 then y = 2x - 150
   *
   * @param amount - The amount that was spent in the purchase.
   * @return the reward points for the amount spent.
   */
  public int calculate(@NonNull BigDecimal amount) {
    if (amount == null)
      throw new AmountNotProvidedException();

    if (amount.compareTo(BigDecimal.valueOf(50)) <= 0)
      return 0;

    if ((amount.compareTo(BigDecimal.valueOf(50)) > 0)
            && (amount.compareTo(BigDecimal.valueOf(100)) <= 0))
      return amount.subtract(BigDecimal.valueOf(50))
                   .intValue();

    return amount.multiply(BigDecimal.valueOf(2))
                 .subtract(BigDecimal.valueOf(150))
                 .intValue();
  }
}