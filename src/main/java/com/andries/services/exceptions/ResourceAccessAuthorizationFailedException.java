package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ResourceAccessAuthorizationFailedException extends BaseResourceException {

    public ResourceAccessAuthorizationFailedException() {
    }

    public ResourceAccessAuthorizationFailedException(String message) {
        super(message);
    }

    public ResourceAccessAuthorizationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAccessAuthorizationFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceAccessAuthorizationFailedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "ACCESS_AUTHORIZATION_FAILED_ERROR";
    }

}
