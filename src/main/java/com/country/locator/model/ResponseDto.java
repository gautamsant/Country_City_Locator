package com.country.locator.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

@JsonSerialize
public class ResponseDto  implements Serializable {

    private String countryName;

    public ResponseDto() {
        super();
    }

    public ResponseDto(String countryName) {
        super();
        this.countryName = countryName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
