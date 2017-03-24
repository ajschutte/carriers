package com.andries.services.exceptions;

/**
 * Created by Andries on 12/15/16.
 */
public class ResourceAccessInternalServiceFailedException extends BaseResourceException {

    public ResourceAccessInternalServiceFailedException() {
    }

    public ResourceAccessInternalServiceFailedException(String message) {
        super(message);
    }

    public ResourceAccessInternalServiceFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAccessInternalServiceFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceAccessInternalServiceFailedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "ACCESS_INTERNAL_SERVICE_FAILED_ERROR";
    }

}
