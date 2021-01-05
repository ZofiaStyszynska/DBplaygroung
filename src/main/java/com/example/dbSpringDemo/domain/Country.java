package com.example.dbSpringDemo.domain;

import com.example.dbSpringDemo.CountryEntity;
import lombok.Value;

import static com.example.dbSpringDemo.domain.Continent.fromContinentEntity;

@Value
public class Country {

    String countryName;
    Continent continent;

    public static Country fromCountryEntity(CountryEntity countryEntity, Continent continent){
        return new Country(countryEntity.getCountryName(), fromContinentEntity(continent));
    }
}
