package com.country.locator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CountryNotFoundExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CountryNotFoundException.class)
    private ResponseEntity<ErrorDto> handleCountryNotFoundException(CountryNotFoundException e){
        ErrorDto error=new ErrorDto();
        error.setMessage(e.getMessage());
        error.setCode("404");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
