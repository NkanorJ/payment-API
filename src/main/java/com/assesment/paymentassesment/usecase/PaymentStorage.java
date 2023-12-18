package com.assesment.paymentassesment.usecase;

import com.assesment.paymentassesment.dto.PaymentRequest;
import com.assesment.paymentassesment.dto.PaymentResponse;
import com.assesment.paymentassesment.dto.Response;

public interface PaymentStorage {
    PaymentResponse makePayment(PaymentRequest paymentRequest);

    Response getAllPayment();
}
