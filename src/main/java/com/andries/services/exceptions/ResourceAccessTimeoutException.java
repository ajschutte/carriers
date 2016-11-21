package com.andries.services.exceptions;

/**
 * Created by andriesschutte on 10/27/16.
 */
public class ResourceAccessTimeoutException extends BaseResourceException {

    public ResourceAccessTimeoutException() {
    }

    public ResourceAccessTimeoutException(String message) {
        super(message);
    }

    public ResourceAccessTimeoutException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAccessTimeoutException(Throwable cause) {
        super(cause);
    }

    public ResourceAccessTimeoutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "ACCESS_TIMEOUT_ERROR";
    }

}
