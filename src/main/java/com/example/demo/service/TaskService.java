package com.example.demo.service;

import com.example.demo.Task;
import com.example.demo.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Task> findById(long id) {
        return taskRepository.findById(id);
    }

    @Transactional
    public Task create(Task request) {
        return taskRepository.save(request);
    }
}

