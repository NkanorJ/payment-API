package com.assesment.paymentassesment.exceptions;

public abstract class AssesmentException extends RuntimeException {

    protected final ExceptionCodeEnum code;

    protected final boolean printStackTrace;

    protected AssesmentException(String message, boolean printStackTrace) {
        super(message);
        this.code = ExceptionCodeEnum.AN_ERROR_OCCURRED;
        this.printStackTrace = printStackTrace;
    }

    protected AssesmentException(ExceptionCodeEnum code, String message, boolean printStackTrace) {
        super(message);
        this.code = code;
        this.printStackTrace = printStackTrace;
    }

    public AssesmentException(String message, Exception cause, boolean printStackTrace) {
        super(message, cause);
        this.code = ExceptionCodeEnum.AN_ERROR_OCCURRED;
        this.printStackTrace = printStackTrace;
    }

    public ExceptionCodeEnum getCode() {
        return code;
    }
}
