package com.assesment.paymentassesment.service;

import com.assesment.paymentassesment.dao.PaymentRepository;
import com.assesment.paymentassesment.dto.PaymentRequest;
import com.assesment.paymentassesment.dto.PaymentResponse;
import com.assesment.paymentassesment.dto.Response;
import com.assesment.paymentassesment.enumeration.PaymentType;
import com.assesment.paymentassesment.exceptions.UnsupportedPaymentTypeException;
import com.assesment.paymentassesment.factory.PaymentFactory;
import com.assesment.paymentassesment.usecase.PaymentStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService implements PaymentStorage {

    private final PaymentFactory paymentFactory;

    private final PaymentRepository paymentRepository;

    @Override
    public PaymentResponse makePayment(PaymentRequest paymentRequest) {

        var paymentChannelResponse = paymentFactory.getPaymentType(paymentRequest.paymentType().name());

        if (paymentChannelResponse.paymentType() == null) {
            throw new UnsupportedPaymentTypeException("Unsupported payment type: " + paymentRequest.paymentType(), false);
        }

        if (paymentChannelResponse.paymentType() == PaymentType.CARD) {
            var payment = new PaymentRequest(
                    paymentRequest.cardNumber(),
                    paymentRequest.emailAddress(),
                    paymentRequest.cvv(),
                    paymentRequest.amount(),
                    paymentRequest.expiryDate(),
                    paymentRequest.currency(),
                    paymentRequest.paymentType(),
                    paymentRequest.phoneNumber());

            paymentRepository.makePayment(payment);

        }

        return new PaymentResponse("Payment successful");
    }

    @Override
    public Response getAllPayment() {

        Response response = new Response<>();

        response.setResponseMessage("Data Fetched Successfully");
        response.setData(paymentRepository.getAllPayment());

        return response;

    }

}
