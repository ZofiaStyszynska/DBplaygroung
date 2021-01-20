package com.example.dbSpringDemo.domain;

import com.example.dbSpringDemo.ContinentEntity;
import com.example.dbSpringDemo.CountryEntity;
import lombok.Value;

import static com.example.dbSpringDemo.domain.Continent.fromContinentEntity;

@Value
public class Country {

    String countryName;
    Continent continent;

    public static Country fromCountryEntity(CountryEntity countryEntity, ContinentEntity continentEntity){

        return new Country(countryEntity.getCountryName(), fromContinentEntity(continentEntity));
    }
}
