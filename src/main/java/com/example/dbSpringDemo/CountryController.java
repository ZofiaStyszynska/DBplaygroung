package com.example.dbSpringDemo;


import com.example.dbSpringDemo.repositories.DbService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    private final DbService service;

    public CountryController(DbService service) {
        this.service = service;
    }
}
