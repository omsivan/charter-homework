package com.charter.homework.retail.charterhomework.exceptions;

public class DateTimeNotProvidedException extends RuntimeException {
  public DateTimeNotProvidedException() {
    super("DateTime MUST be provided for the Customer Purchase.");
  }
}
