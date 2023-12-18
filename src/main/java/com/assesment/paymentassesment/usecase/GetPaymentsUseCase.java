package com.assesment.paymentassesment.usecase;

import an.awesome.pipelinr.Command;
import com.assesment.paymentassesment.dto.GetPaymentsCommand;
import com.assesment.paymentassesment.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPaymentsUseCase implements Command.Handler<GetPaymentsCommand, Response> {

    private final PaymentStorage paymentStorage;

    @Override
    public Response handle(GetPaymentsCommand request) {
        return paymentStorage.getAllPayment();
    }
}
