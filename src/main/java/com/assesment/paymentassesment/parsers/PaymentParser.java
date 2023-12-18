package com.assesment.paymentassesment.parsers;

import com.assesment.paymentassesment.dto.PaymentTypeResponse;

public interface PaymentParser {
    boolean supports(String paymentType);

    PaymentTypeResponse parsePayment(String accountIdentifier);
}
