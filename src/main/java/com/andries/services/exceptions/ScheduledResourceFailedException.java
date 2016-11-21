package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ScheduledResourceFailedException extends BaseResourceException {

    public ScheduledResourceFailedException() {
    }

    public ScheduledResourceFailedException(String message) {
        super(message);
    }

    public ScheduledResourceFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScheduledResourceFailedException(Throwable cause) {
        super(cause);
    }

    public ScheduledResourceFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "SCHEDULED_RESOURCE_FAILED_ERROR";
    }

}
