package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ResourceUpdateFailedException extends BaseResourceException {

    public ResourceUpdateFailedException() {
    }

    public ResourceUpdateFailedException(String message) {
        super(message);
    }

    public ResourceUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceUpdateFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceUpdateFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "UPDATE_FAILED_ERROR";
    }

}
