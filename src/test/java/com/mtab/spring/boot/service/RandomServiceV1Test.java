package com.mtab.spring.boot.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomServiceV1Test {

    @Mock
    private Random random;

    @InjectMocks
    private RandomServiceV1 service;

    @Test
    void generateRandomNumber() {
        var expected = 10;
        when(this.random.nextInt()).thenReturn(expected);
        var actual = this.service.generateRandomNumber();
        assertEquals(expected, actual);
    }
}