package com.assesment.paymentassesment.model;

import com.assesment.paymentassesment.enumeration.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Currency;

@Data
@Entity
@NoArgsConstructor
@Table(name = "payment")
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String emailAddress;

    private String firstName;

    private String lastName;

    private Currency currency;

    private String phoneNumber;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    public Payment(String emailAddress, String firstName, String lastName, Currency currency, String phoneNumber,
                   BigDecimal amount, PaymentType paymentType) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currency = currency;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.paymentType = paymentType;
    }
}
