package com.example.todo.dto.tasks;

public record TaskListResponse(
        Long id,
        String summary,
        String status
) {
}
