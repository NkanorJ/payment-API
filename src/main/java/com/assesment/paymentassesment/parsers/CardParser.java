package com.assesment.paymentassesment.parsers;

import com.assesment.paymentassesment.dao.PaymentRepository;
import com.assesment.paymentassesment.dto.PaymentTypeResponse;
import com.assesment.paymentassesment.enumeration.PaymentType;
import com.assesment.paymentassesment.exceptions.RecordNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardParser implements PaymentParser {

    @Override
    public boolean supports(String paymentType) {
        return StringUtils.isNotBlank(paymentType) && paymentType.contains(PaymentType.CARD.name());
    }

    @Override
    public PaymentTypeResponse parsePayment(String identifier) {

        return Optional.ofNullable(identifier)
                .filter(StringUtils::isNotBlank)
                .map(id -> new PaymentTypeResponse(PaymentType.CARD, identifier))
                .orElseThrow(() -> new RecordNotFoundException("Card number is blank or null", false));
    }
}
