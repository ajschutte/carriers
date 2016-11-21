package com.andries.services.exceptions;

/**
 * Created by andriesschutte on 11/2/16.
 */
public class ResourceAccessInterruptedException extends BaseResourceException {

    public ResourceAccessInterruptedException() {
    }

    public ResourceAccessInterruptedException(String message) {
        super(message);
    }

    public ResourceAccessInterruptedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAccessInterruptedException(Throwable cause) {
        super(cause);
    }

    public ResourceAccessInterruptedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "ACCESS_INTERRUPTED_ERROR";
    }

}
