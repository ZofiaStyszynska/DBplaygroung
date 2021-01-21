package com.example.dbSpringDemo.repositories;


import com.example.dbSpringDemo.ContinentEntity;
import com.example.dbSpringDemo.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Set;
import java.util.UUID;


public interface CountryRepository extends JpaRepository <CountryEntity, UUID>{

Set<CountryEntity> findCountryEntitiesByContinentEntity_ContinentName(String continentName);

}
