package com.example.dbSpringDemo.domain;

import com.example.dbSpringDemo.ContinentEntity;
import lombok.Value;

@Value
public class Continent {

    String continentName;

    public static Continent fromContinentEntity(ContinentEntity continentEntity){
        return new Continent(continentEntity.getContinentName());
    }
}
