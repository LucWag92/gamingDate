package com.gamingdate.exceptions;

public class EMailException extends Exception {
    public EMailException(String email) {
        super("Email is already in DB: " + email);
    }
}
