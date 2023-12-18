package com.assesment.paymentassesment.usecase;

import com.assesment.paymentassesment.dto.Response;

public interface CommandHandler<T, T1> {
    Response handle(Void unused);
}
