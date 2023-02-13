package com.example.wiremock.controller;

import com.example.wiremock.model.TodoDto;
import com.example.wiremock.util.SpringBootTestConfiguration;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(SpringBootTestConfiguration.class)
class TodoControllerIntegrationTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private WireMockServer wireMockServer;

    @BeforeEach
    void setup() {
        wireMockServer.start();
    }
    @AfterEach
    void tearDown() {
        wireMockServer.stop();
    }

    @Test
    void testGetTodoById(){
        ResponseEntity<TodoDto> response =  testRestTemplate.getForEntity("/todos/1", TodoDto.class);
        TodoDto todoDto = response.getBody();
        assertNotNull(todoDto);
        assertEquals(todoDto.getId(), 200);
        assertEquals(todoDto.getUserId(), 100);
        assertEquals(todoDto.getTitle(), "TITLE");
        assertEquals(todoDto.isCompleted(), false);
    }
}