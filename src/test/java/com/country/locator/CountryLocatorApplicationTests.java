package com.country.locator;

import com.country.locator.controller.CountryLocatorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CountryLocatorApplicationTests {

    @Autowired
    private CountryLocatorController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
