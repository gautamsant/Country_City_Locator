package com.country.locator.exception;

public class CountryNotFoundException extends Exception {

    private String errorMessage;

    public CountryNotFoundException(String message) {
        super(message);
        this.errorMessage = message;
    }
}
