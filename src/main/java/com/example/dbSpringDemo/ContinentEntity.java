package com.example.dbSpringDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity (name = "Continent")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContinentEntity {

    @Id
    @GeneratedValue
    UUID continentId;
    String continentName;
    @Column (nullable = true)
    @OneToMany
    Set<CountryEntity> countryEntities;


}

