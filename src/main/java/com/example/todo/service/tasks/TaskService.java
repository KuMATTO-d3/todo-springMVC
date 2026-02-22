package com.example.todo.service.tasks;

import com.example.todo.dto.tasks.TaskListResponse;
import com.example.todo.entity.tasks.Task;
import com.example.todo.repository.tasks.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<TaskListResponse> getTaskList() {
        return taskRepository.findAll()
                .stream()
                .map(task -> new TaskListResponse(
                        task.getId(),
                        task.getSummary(),
                        task.getStatus().name()
                ))
                .toList();
    }
}
