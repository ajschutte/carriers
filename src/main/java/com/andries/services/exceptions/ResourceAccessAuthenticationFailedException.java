package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ResourceAccessAuthenticationFailedException extends BaseResourceException {

    public ResourceAccessAuthenticationFailedException() {
    }

    public ResourceAccessAuthenticationFailedException(String message) {
        super(message);
    }

    public ResourceAccessAuthenticationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAccessAuthenticationFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceAccessAuthenticationFailedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "ACCESS_AUTHENTICATION_FAILED_ERROR";
    }

}
