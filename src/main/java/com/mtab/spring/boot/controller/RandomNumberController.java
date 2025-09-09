package com.mtab.spring.boot.controller;

import com.mtab.spring.boot.service.RandomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.requireNonNull;

@RestController
public class RandomNumberController {

    private final RandomService service;

    public RandomNumberController(
            final RandomService service) {
        this.service = requireNonNull(service);
    }

    @GetMapping(value = "/random")
    public int generateRandomNumber() {
        return this.service.generateRandomNumber();
    }
}
