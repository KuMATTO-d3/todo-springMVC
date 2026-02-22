package com.example.todo.entity.tasks;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String summary;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    public Task(String summary, String description) {
        this.summary = summary;
        this.description = description;
        this.status = TaskStatus.TODO;
    }
}