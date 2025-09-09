package com.mtab.spring.boot.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RandomNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void generateRandomNumber() throws Exception {
        var url = "/random";
        var response = this.mockMvc
                .perform(get(url))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();
        assertNotNull(response);
        assertDoesNotThrow(() -> Integer.parseInt(response));
    }
}