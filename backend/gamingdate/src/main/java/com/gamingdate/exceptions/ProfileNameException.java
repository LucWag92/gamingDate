package com.gamingdate.exceptions;

public class ProfileNameException extends Exception{
    public ProfileNameException(String profileName) {
        super("profileName is already in DB: " + profileName);
    }
}
