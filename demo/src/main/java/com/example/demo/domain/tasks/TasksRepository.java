package com.example.demo.domain.tasks;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository {

    // Listar todas as tasks
    List<Tasks> findAllTasks(int offset);

    // id última tasks
    int idLastTasks();

    // Número total de tasks
    int totalTasks();

    // contar quantas tasks estão finalizadas
    int countAllTasks();

    // Media de prioridade das tasks pendentes
    PriorityTask mediaPriority();

    // Listar task por id
    Tasks findById(int id_task);

    // Create task
    Boolean insertTask(Tasks task);

    // Update task
    Boolean updateTask(Tasks task);

    // Delete task
    Boolean deleteTask(int id_task);
}
