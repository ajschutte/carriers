package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ResourceStaleVersionException extends BaseResourceException {

    public ResourceStaleVersionException() {
    }

    public ResourceStaleVersionException(String message) {
        super(message);
    }

    public ResourceStaleVersionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceStaleVersionException(Throwable cause) {
        super(cause);
    }

    public ResourceStaleVersionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "STALE_VERSION_ERROR";
    }

}
