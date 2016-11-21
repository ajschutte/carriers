package com.andries.services.exceptions;

/**
 * Created by andriesschutte on 11/2/16.
 */
public class ResourceBusinessLogicFailedException extends BaseResourceException {

    public ResourceBusinessLogicFailedException() {
    }

    public ResourceBusinessLogicFailedException(String message) {
        super(message);
    }

    public ResourceBusinessLogicFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceBusinessLogicFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceBusinessLogicFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "BUSINESS_LOGIC_FAILED_ERROR";
    }

}
