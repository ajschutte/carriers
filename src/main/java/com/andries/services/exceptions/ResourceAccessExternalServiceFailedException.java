package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ResourceAccessExternalServiceFailedException extends BaseResourceException {

    public ResourceAccessExternalServiceFailedException() {
    }

    public ResourceAccessExternalServiceFailedException(String message) {
        super(message);
    }

    public ResourceAccessExternalServiceFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAccessExternalServiceFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceAccessExternalServiceFailedException(String message, Throwable cause, boolean enableSuppression,
                                                        boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "ACCESS_EXTERNAL_SERVICE_FAILED_ERROR";
    }

}
