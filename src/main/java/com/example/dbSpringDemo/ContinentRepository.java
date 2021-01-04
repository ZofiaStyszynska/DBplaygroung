package com.example.dbSpringDemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContinentRepository <C extends ContinentEntity> extends JpaRepository<C, UUID> {


}
