package com.country.locator.service;

import com.country.locator.exception.CountryNotFoundException;

public interface ICountryLocatorService {

    String getCountryByCity(String cityName) throws CountryNotFoundException;
}
