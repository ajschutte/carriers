package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public abstract class BaseResourceException extends RuntimeException {

    private String component;

    public BaseResourceException() {
    }

    public BaseResourceException(String message) {
        super(message);
    }

    public BaseResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseResourceException(Throwable cause) {
        super(cause);
    }

    public BaseResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getCode() {
        return getClass().getSimpleName();
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String aComponent) {
        this.component = aComponent;
    }

}
