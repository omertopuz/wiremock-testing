package com.example.wiremock.controller;

import com.example.wiremock.model.TodoDto;
import com.example.wiremock.service.TodoApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/todos")
@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoApiService todoApiService;

    @GetMapping("/{todoId}")
    public TodoDto getTodo(@PathVariable String todoId) throws JsonProcessingException {
        return todoApiService.getTodoById(todoId);
    }
}
