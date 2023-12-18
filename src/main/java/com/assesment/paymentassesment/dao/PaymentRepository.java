package com.assesment.paymentassesment.dao;

import com.assesment.paymentassesment.dto.PaymentRequest;
import com.assesment.paymentassesment.dto.PaymentResponse;
import com.assesment.paymentassesment.dto.PaymentResponseDto;
import com.assesment.paymentassesment.enumeration.PaymentType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Service
public class PaymentRepository {

    public List<String> getAccountIdentifiers() {
        return List.of("123456", "678909876", "22627737723");
    }

    public List<PaymentResponseDto> getAllPayment() {

        return List.of(
                new PaymentResponseDto(1L, "janeetim248@gmail.com", "123", BigDecimal.valueOf(100.00), "12/45",
                        Currency.getInstance("NGN"), PaymentType.CARD, "07060482184"),

                new PaymentResponseDto(2L, "janeetim248@gmail.com", "123", BigDecimal.valueOf(200.00), "12/24",
                        Currency.getInstance("NGN"), PaymentType.CARD, "07060482184")
        );

    }

    public PaymentResponse makePayment(PaymentRequest request) {

        return new PaymentResponse("Payment successful");
    }
}
