package com.country.locator.service;

import com.country.locator.exception.CountryNotFoundException;
import com.country.locator.repository.CityCountryRepository;
import com.country.locator.entity.CityCountryMapping;
import com.country.locator.service.impl.CountryLocatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = { CountryLocatorService.class})
public class CountryLocatorServiceTest {

    @MockBean
    private CityCountryRepository repository;

    @Autowired
    private CountryLocatorService countryLocatorService;

    @Test
    void shouldReturnCountry_Success() throws CountryNotFoundException {
        when(repository.findByCityIgnoreCase("Texas"))
                .thenReturn(new CityCountryMapping(1L, "Texas", "United States"));

        assertThat(countryLocatorService.getCountryByCity("Texas"))
                .isNotNull()
                .isEqualTo("United States");
    }

    @Test()
    void shouldReturnCountry_Failure() {
        when(repository.findByCityIgnoreCase(anyString())).thenReturn(null);

        Exception exception = assertThrows(CountryNotFoundException.class, () ->
                countryLocatorService.getCountryByCity("City"));
        assertThat(exception.getMessage().contains("Country Not Found for the City"));


    }


}
