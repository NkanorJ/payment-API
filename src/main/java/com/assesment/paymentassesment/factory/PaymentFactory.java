package com.assesment.paymentassesment.factory;

import com.assesment.paymentassesment.dto.PaymentTypeResponse;
import com.assesment.paymentassesment.enumeration.PaymentType;
import com.assesment.paymentassesment.parsers.PaymentParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentFactory {

    private final List<PaymentParser> parsers;

    public PaymentTypeResponse getPaymentType(String request) {

        return parsers.stream()
                .filter(p -> p.supports(request))
                .findFirst()
                .map(p -> p.parsePayment(request))
                .orElse(new PaymentTypeResponse(PaymentType.UNKNOWN, request));

    }
}
