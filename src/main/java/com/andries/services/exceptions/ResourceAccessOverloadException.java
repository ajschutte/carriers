package com.andries.services.exceptions;

/**
 * Created by andriesschutte on 10/27/16.
 */
public class ResourceAccessOverloadException extends BaseResourceException {

    public ResourceAccessOverloadException() {
    }

    public ResourceAccessOverloadException(String message) {
        super(message);
    }

    public ResourceAccessOverloadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceAccessOverloadException(Throwable cause) {
        super(cause);
    }

    public ResourceAccessOverloadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "ACCESS_OVERLOAD_ERROR";
    }

}
