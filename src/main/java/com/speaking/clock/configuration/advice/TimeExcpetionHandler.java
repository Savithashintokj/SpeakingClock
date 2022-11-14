package com.speaking.clock.configuration.advice;

import com.speaking.clock.exception.TimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class TimeExcpetionHandler {
    Logger logger = LoggerFactory.getLogger(TimeExcpetionHandler.class);

    @ExceptionHandler(TimeException.class)
    protected ResponseEntity<String> handleTimeException(TimeException ex){
        return new ResponseEntity<>(
                ex.getTimeErrors().getErrorMessage(),   ex.getTimeErrors().getHttpStatusCode());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<String> handleInternalException(Exception ex){
        return new ResponseEntity<>(
               "There are some issues in the system. Please try again later", HttpStatus.BAD_REQUEST);
    }
}
