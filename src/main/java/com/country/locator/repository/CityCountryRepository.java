package com.country.locator.repository;

import com.country.locator.entity.CityCountryMapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityCountryRepository extends CrudRepository<CityCountryMapping, Long> {

    CityCountryMapping findByCityIgnoreCase(String city);
}
