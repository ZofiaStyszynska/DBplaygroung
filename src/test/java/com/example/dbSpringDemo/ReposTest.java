package com.example.dbSpringDemo;

import com.example.dbSpringDemo.repositories.ContinentRepository;
import com.example.dbSpringDemo.repositories.CountryRepository;
import com.example.dbSpringDemo.repositories.DbService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//import static com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat.UUID;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ReposTest {


    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ContinentRepository continentRepository;


    ContinentEntity europe = new ContinentEntity(null, "Europe", null);
    ContinentEntity asia = new ContinentEntity(null, "Asia", null);
    ContinentEntity africa = new ContinentEntity(null, "Africa", null);

    CountryEntity poland = new CountryEntity(null, "Polska", europe);
    CountryEntity mongolia = new CountryEntity(null, "Mongolia", asia);
    CountryEntity tanzania = new CountryEntity(null, "Tanzania", africa);
    CountryEntity germany = new CountryEntity(null, "Niemcy", europe);

    @BeforeEach
    void setUpContinents() {
        continentRepository.saveAll(List.of(europe, asia, africa));
    }

    @BeforeEach
    void setUpCountries() {

        countryRepository.saveAll(List.of(poland, mongolia, tanzania, germany));

    }

    @Test
    void should_find_all_countries() {


        final List<CountryEntity> allCountries = countryRepository.findAll();

        assertThat(allCountries.size()).isEqualTo(3);

    }

    @Test
    void should_find_countries_in_a_continent() {
        final Set<CountryEntity> countryEntities = countryRepository.findCountryEntitiesByContinentEntity_ContinentName(europe.getContinentName());
        String polandName = countryEntities.stream()
                .map(CountryEntity::getCountryName)
                .collect(Collectors.joining(" "));

        assertThat(countryEntities.size()).isEqualTo(2);
        assertThat(polandName.contentEquals("Tanzania"));


    }

    @Test
    void should_find_a_country_in_a_continent() {
        final Set<CountryEntity> countryEntities = countryRepository.findCountryEntitiesByContinentEntity_ContinentName(europe.getContinentName());
        assertThat(countryEntities.contains(poland));
    }

    @Test
    void should_NOT_find_a_country_in_a_continent() {

        final Set<CountryEntity> countryEntities = countryRepository.findCountryEntitiesByContinentEntity_ContinentName(europe.getContinentName());
        assertThat(countryEntities.contains(tanzania));
    }


}
