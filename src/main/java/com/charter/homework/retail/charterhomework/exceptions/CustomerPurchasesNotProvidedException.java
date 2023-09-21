package com.charter.homework.retail.charterhomework.exceptions;

public class CustomerPurchasesNotProvidedException extends RuntimeException {
  public CustomerPurchasesNotProvidedException() {
    super("Customer Purchases MUST be provided for the Customer Purchase.");
  }
}
