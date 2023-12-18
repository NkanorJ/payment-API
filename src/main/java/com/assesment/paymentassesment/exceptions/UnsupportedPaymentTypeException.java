package com.assesment.paymentassesment.exceptions;

public class UnsupportedPaymentTypeException extends AssesmentException {
    public UnsupportedPaymentTypeException(String message, boolean printStackTrace) {
        super(message, printStackTrace);
    }
}
