package com.gamingdate.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import com.gamingdate.exceptions.exception.AccountDataNotFoundException;

@ControllerAdvice
public class AccountDataExceptions {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({AccountDataNotFoundException.class})
    public void handle(AccountDataNotFoundException e) {}
}
