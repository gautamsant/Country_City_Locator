package com.country.locator.controller;

import com.country.locator.exception.CountryNotFoundException;
import com.country.locator.service.impl.CountryLocatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class CountryLocatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryLocatorService service;


    @Test
    void shouldReturnCountry_Success() throws Exception {
        when(service.getCountryByCity(anyString())).thenReturn("UNITED_STATES");

        this.mockMvc.perform(get("/country?city=TEXAS")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string("{\"countryName\":\"UNITED_STATES\"}"));
    }

    @Test
    void shouldReturnCountry_Failure() throws Exception {
        String countryNotFound = "{\"countryName\":null}";
        when(service.getCountryByCity(anyString())).thenThrow(new CountryNotFoundException("Country Not Found"));

        this.mockMvc.perform(get("/country?city=he")).andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().string(countryNotFound));
    }
}
