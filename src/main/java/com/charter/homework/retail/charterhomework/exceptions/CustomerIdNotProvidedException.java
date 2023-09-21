package com.charter.homework.retail.charterhomework.exceptions;

public class CustomerIdNotProvidedException extends RuntimeException {
  public CustomerIdNotProvidedException() {
    super("Customer Id MUST be provided for the Customer Purchase.");
  }
}
