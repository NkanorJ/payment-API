package com.assesment.paymentassesment.dto;

import com.assesment.paymentassesment.enumeration.PaymentType;

import java.math.BigDecimal;
import java.util.Currency;

public record PaymentResponseDto(Long id, String emailAddress, String cvv, BigDecimal amount, String expiryDate,
                                 Currency currency, PaymentType paymentType,
                                 String phoneNumber) {

}
