package com.example.wiremock.service;

import com.example.wiremock.model.TodoDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TodoApiService {

    @Value("${todoApi.baseUrl}")
    private String todoApiUrl;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public TodoDto getTodoById(String id) throws JsonProcessingException {
        String url = todoApiUrl.concat("/todos/").concat(id);
        String todoDtoStr = restTemplate.getForObject(url, String.class);
        return objectMapper.readValue(todoDtoStr, TodoDto.class);
    }
}
