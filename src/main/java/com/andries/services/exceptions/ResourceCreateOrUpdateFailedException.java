package com.andries.services.exceptions;

/**
 * Created by Andries on 11/10/16.
 */
public class ResourceCreateOrUpdateFailedException extends BaseResourceException {

    public ResourceCreateOrUpdateFailedException() {
    }

    public ResourceCreateOrUpdateFailedException(String message) {
        super(message);
    }

    public ResourceCreateOrUpdateFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceCreateOrUpdateFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceCreateOrUpdateFailedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
