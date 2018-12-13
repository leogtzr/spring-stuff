package com.learning.data.dataplaying.repository;

import com.learning.data.dataplaying.domain.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Integer> {
    List<Country> findByName(String name);
}
