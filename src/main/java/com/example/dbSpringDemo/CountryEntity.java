package com.example.dbSpringDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "Country")
@AllArgsConstructor
@NoArgsConstructor

public class CountryEntity {

    @Id
    @GeneratedValue
    UUID countryId;
    String countryName;
    @JoinColumn
    @ManyToOne
    ContinentEntity continentEntity;

    public CountryEntity(String countryName) {

    }

    public CountryEntity(String countryName, ContinentEntity continentEntity) {

    }

    public UUID getCountryId() {
        return countryId;
    }

    public void setCountryId(UUID countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public ContinentEntity getContinentEntity() {
        return continentEntity;
    }

    public void setContinentEntity(ContinentEntity continentEntity) {
        this.continentEntity = continentEntity;
    }
}
