package com.assesment.paymentassesment.dto;


import com.assesment.paymentassesment.enumeration.PaymentType;

public record PaymentTypeResponse(PaymentType paymentType, String accountIdentifier) {
}
