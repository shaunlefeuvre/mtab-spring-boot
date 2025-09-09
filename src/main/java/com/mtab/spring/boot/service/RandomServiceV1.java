package com.mtab.spring.boot.service;

import org.springframework.stereotype.Service;

import java.util.Random;

import static java.util.Objects.requireNonNull;

@Service
public class RandomServiceV1 implements RandomService {

    private final Random random;

    public RandomServiceV1(
            final Random random) {
        this.random = requireNonNull(random);
    }

    @Override
    public int generateRandomNumber() {
        return this.random.nextInt();
    }
}
