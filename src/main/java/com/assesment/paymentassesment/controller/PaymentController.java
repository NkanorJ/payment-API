package com.assesment.paymentassesment.controller;

import an.awesome.pipelinr.Pipeline;
import com.assesment.paymentassesment.dto.GetPaymentsCommand;
import com.assesment.paymentassesment.dto.PaymentRequest;
import com.assesment.paymentassesment.dto.PaymentResponse;
import com.assesment.paymentassesment.dto.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final Pipeline pipeline;

    @PostMapping("/make-payment")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PaymentResponse makePayment(@RequestBody PaymentRequest request) {
        return pipeline.send(request);
    }

    @GetMapping()
    public Response getPayments() {
        return pipeline.send(new GetPaymentsCommand());
    }
}
