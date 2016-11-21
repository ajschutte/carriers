package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ResourceDataValidationFailedException extends BaseResourceException {

    public ResourceDataValidationFailedException() {
    }

    public ResourceDataValidationFailedException(String message) {
        super(message);
    }

    public ResourceDataValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceDataValidationFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceDataValidationFailedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "DATA_VALIDATION_FAILED_ERROR";
    }

}
