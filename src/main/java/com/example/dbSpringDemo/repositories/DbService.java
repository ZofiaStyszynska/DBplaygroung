package com.example.dbSpringDemo.repositories;

import com.example.dbSpringDemo.ContinentEntity;
import com.example.dbSpringDemo.CountryEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class DbService {

    private final ContinentRepository continentRepository;
    private final CountryRepository countryRepository;

    public DbService(ContinentRepository continentRepository, CountryRepository countryRepository) {
        this.continentRepository = continentRepository;
        this.countryRepository = countryRepository;
    }

    public UUID addCountry (CountryEntity country, ContinentEntity continentEntity){

        country = countryRepository.save(new CountryEntity(null, country.getCountryName(),continentEntity));

        return country.getCountryId();
    }

    public UUID addContinent(ContinentEntity continentEntity){
        continentEntity = continentRepository.save(new ContinentEntity(null,
                continentEntity.getContinentName(),
                countryRepository.findCountryEntitiesByContinentEntity_ContinentName(continentEntity.getContinentName())));
                return continentEntity.getContinentId();
    }
    public Set<CountryEntity> findCountriesByContinentName(String continentName){
        Set<CountryEntity> countryEntities = countryRepository.findCountryEntitiesByContinentEntity_ContinentName(continentName);
        if(!countryEntities.isEmpty()){
            return countryEntities;
        }else{
            return null;
        }
    }
//    public Optional <Country> getCountry(UUID id) {
//        return countryRepository.findById(id)
//                //.(Continent::fromContinentEntity)
//                .map(Country::fromCountryEntity);
//
//    }


}
