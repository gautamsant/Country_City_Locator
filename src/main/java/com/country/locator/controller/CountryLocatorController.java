package com.country.locator.controller;

import com.country.locator.exception.CountryNotFoundException;
import com.country.locator.model.ResponseDto;
import com.country.locator.service.ICountryLocatorService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryLocatorController {

    @Autowired
    private ICountryLocatorService countryLocatorService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> getCountryByCity(@NotNull @RequestParam("city") String cityName) throws CountryNotFoundException {
        ResponseDto responseDto=new ResponseDto(countryLocatorService.getCountryByCity(cityName));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
