package com.example.dbSpringDemo.repositories;

import com.example.dbSpringDemo.ContinentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContinentRepository extends JpaRepository<ContinentEntity, UUID> {

}
