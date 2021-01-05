package com.example.dbSpringDemo.domain;

import lombok.Value;

@Value
public class Continent {

    String continentName;

    public static Continent fromContinentEntity(Continent continent){
        return new Continent(continent.getContinentName());
    }
}
