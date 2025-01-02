package com.example.demo.domain.tasks;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TasksRepository {

    // Listar todas as tasks
    List<Tasks> findAllTasks();

    // Listar task por id
    Tasks findById(UUID id);

    // Create task
    Boolean saveTask(Tasks task);

    // Update task
    Boolean updateTask(Tasks task);

    // Delete task
    Boolean deleteTask(Tasks task);
}
