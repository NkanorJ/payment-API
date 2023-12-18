package com.assesment.paymentassesment.dto;

import an.awesome.pipelinr.Command;
import com.assesment.paymentassesment.enumeration.PaymentType;

import java.math.BigDecimal;
import java.util.Currency;

public record PaymentRequest(String cardNumber, String emailAddress, String cvv, BigDecimal amount, String expiryDate,
                             Currency currency, PaymentType paymentType,
                             String phoneNumber) implements Command<PaymentResponse> {

    public PaymentRequest(String cardNumber, String emailAddress, String cvv, BigDecimal amount, String expiryDate, Currency currency, PaymentType paymentType, String phoneNumber) {
        this.cardNumber = cardNumber;
        this.emailAddress = emailAddress;
        this.cvv = cvv;
        this.amount = amount;
        this.expiryDate = expiryDate;
        this.currency = currency;
        this.paymentType = paymentType;
        this.phoneNumber = phoneNumber;
    }
}
