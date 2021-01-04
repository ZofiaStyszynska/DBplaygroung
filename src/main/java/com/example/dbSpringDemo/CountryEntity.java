package com.example.dbSpringDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity(name = "Country")
@AllArgsConstructor
@NoArgsConstructor

public class CountryEntity extends ContinentEntity {

    @Id
    UUID countryId;
    String countryName;

    public CountryEntity(String countryName) {

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
}
