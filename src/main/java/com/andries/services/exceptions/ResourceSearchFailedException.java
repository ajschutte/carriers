package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ResourceSearchFailedException extends BaseResourceException {

    public ResourceSearchFailedException() {
    }

    public ResourceSearchFailedException(String message) {
        super(message);
    }

    public ResourceSearchFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceSearchFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceSearchFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "SEARCH_FAILED_ERROR";
    }

}
