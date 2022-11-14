package com.speaking.clock.errors;

import org.springframework.http.HttpStatus;

public enum TimeErrors {

    INVALID_HOUR("Invalid Hour", 100, HttpStatus.BAD_REQUEST),
    INVALID_MIN("Invalid Min", 101, HttpStatus.BAD_REQUEST),
    UNKNOWN_ERROR("Unknown Error", 999, HttpStatus.BAD_REQUEST),
    INVALID_TIME("Invalid Time", 102, HttpStatus.BAD_REQUEST);

    private final String errorMessage;
    private final long errorCode;
    private final HttpStatus httpStatusCode;

    TimeErrors(String errorMessage, long errorCode, HttpStatus httpStatusCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.httpStatusCode = httpStatusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }
}
