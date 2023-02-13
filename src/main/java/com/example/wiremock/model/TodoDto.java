package com.example.wiremock.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TodoDto {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
