package com.assesment.paymentassesment.exceptions;

import lombok.Getter;

@Getter
public enum ExceptionCodeEnum {
    AN_ERROR_OCCURRED("PROCESSING-ERROR-2000"),

    TWO_FACTOR_REQUIRED("TWO-FACTOR-REQUIRED-2001"),

    ID_INFORMATION_REQUIRED("ID-INFORMATION-REQUIRED-2003"),

    EXTRA_AUTHENTICATION_REQUIRED("EXTRA-AUTHENTICATION-REQUIRED-2002"),

    SUCCESSFUL("PROCESSED-SUCCESSFULLY-2004");

    private final String message;

    ExceptionCodeEnum(String message) {

        this.message = message;
    }
}
