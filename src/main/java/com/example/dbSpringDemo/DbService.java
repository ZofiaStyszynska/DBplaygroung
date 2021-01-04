package com.example.dbSpringDemo;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DbService {

private final ContinentRepository repository;


    public DbService(ContinentRepository repository) {
        this.repository = repository;
    }

    public UUID addCountry (CountryEntity country){

        country = (CountryEntity) repository.save(new CountryEntity(null, "Polska"));

        return country.getCountryId();
    }
}
