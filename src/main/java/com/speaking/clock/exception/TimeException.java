package com.speaking.clock.exception;

import com.speaking.clock.errors.TimeErrors;

/**
 * Created by Savitha Shinto.
 */
public class TimeException extends Exception {
    private final TimeErrors timeErrors;
    public TimeErrors getTimeErrors() {
        return timeErrors;
    }

    public TimeException(TimeErrors timeErrors) {
        super(timeErrors.getErrorMessage());
        this.timeErrors = timeErrors;
    }
}
