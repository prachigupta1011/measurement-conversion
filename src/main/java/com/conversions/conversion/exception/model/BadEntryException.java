package com.conversions.conversion.exception.model;

public class BadEntryException extends RuntimeException {

    private static final long serialVersionUID = 2324345777777777777L;

    private final String errorDetails;

    public BadEntryException(String message, String details) {
        super(message);
        errorDetails = details;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

}
