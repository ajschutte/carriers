package com.andries.services.exceptions;

/**
 * Created by Andries on 10/19/16.
 */
public class ResourceMetadataValidationFailedException extends BaseResourceException {

    public ResourceMetadataValidationFailedException() {
    }

    public ResourceMetadataValidationFailedException(String message) {
        super(message);
    }

    public ResourceMetadataValidationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceMetadataValidationFailedException(Throwable cause) {
        super(cause);
    }

    public ResourceMetadataValidationFailedException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    @Override
    public String getCode() {
        return "METADATA_VALIDATION_FAILED_ERROR";
    }

}
