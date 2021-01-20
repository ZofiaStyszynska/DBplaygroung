package com.example.dbSpringDemo;

import com.example.dbSpringDemo.repositories.ContinentRepository;
import com.example.dbSpringDemo.repositories.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

//import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.UUID;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ReposTest {


    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ContinentRepository continentRepository;

    ContinentEntity europe = new ContinentEntity(null, "Europe",countryRepository.findAllByContinentEntity_ContinentName("Europe"));
    ContinentEntity asia = new ContinentEntity(null, "Asia",countryRepository.findAllByContinentEntity_ContinentName("Asia"));
    ContinentEntity africa = new ContinentEntity(null, "Africa",countryRepository.findAllByContinentEntity_ContinentName("Africa"));

    @BeforeEach
    void setUpContinents() {
        continentRepository.saveAll(List.of(europe, asia, africa));
    }

    @BeforeEach
    void setUpCountries() {
        CountryEntity poland = new CountryEntity(null, "Polska", europe);
        CountryEntity mongolia = new CountryEntity(null, "Mongolia", asia);
        CountryEntity tanzania = new CountryEntity(null, "Tanzania", africa);
        countryRepository.saveAll(List.of(poland, mongolia, tanzania));

    }

    @Test
    void should_find_all_countries() {


        final List<CountryEntity> allCountries = countryRepository.findAll();

        assertThat(allCountries.size()).isEqualTo(3);

    }


}
