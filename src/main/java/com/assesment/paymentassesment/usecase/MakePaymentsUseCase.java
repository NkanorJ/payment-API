package com.assesment.paymentassesment.usecase;

import an.awesome.pipelinr.Command;
import com.assesment.paymentassesment.dto.PaymentRequest;
import com.assesment.paymentassesment.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MakePaymentsUseCase implements Command.Handler<PaymentRequest, PaymentResponse> {

    private final PaymentStorage paymentStorage;

    @Override
    public PaymentResponse handle(PaymentRequest request) {

        return paymentStorage.makePayment(request);
    }
}
