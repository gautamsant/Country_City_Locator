package com.country.locator.service.impl;

import com.country.locator.exception.CountryNotFoundException;
import com.country.locator.entity.CityCountryMapping;
import com.country.locator.repository.CityCountryRepository;
import com.country.locator.service.ICountryLocatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryLocatorService implements ICountryLocatorService {

    @Autowired
    private CityCountryRepository cityCountryRepository;

    @Override
    public String getCountryByCity(String cityName) throws CountryNotFoundException {
        CityCountryMapping cityCountryMapping = cityCountryRepository.findByCityIgnoreCase(cityName);
        if (cityCountryMapping == null) {
            throw new CountryNotFoundException("Country Not Found for the City");
        }
        return cityCountryMapping.getCountry();
    }
}
