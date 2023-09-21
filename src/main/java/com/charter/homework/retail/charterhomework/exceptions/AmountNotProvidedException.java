package com.charter.homework.retail.charterhomework.exceptions;

public class AmountNotProvidedException extends RuntimeException{
  public AmountNotProvidedException() {
    super("Amount MUST be provided for the Customer Purchase.");

  }
}
