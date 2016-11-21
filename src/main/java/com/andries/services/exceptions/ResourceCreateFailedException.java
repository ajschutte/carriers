package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ResourceCreateFailedException extends BaseResourceException {

    public ResourceCreateFailedException() {
    }

    public ResourceCreateFailedException(String message) {
        super(message);
    }

    public ResourceCreateFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceCreateFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceCreateFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "CREATE_FAILED_ERROR";
    }

}
