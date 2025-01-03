package com.example.demo.adapter.http.tasks;

import com.example.demo.application.tasks.TaskCreateDTO;
import com.example.demo.application.tasks.TaskService;
import com.example.demo.application.tasks.TaskUpdateDTO;
import com.example.demo.domain.tasks.PriorityTask;
import com.example.demo.domain.tasks.Tasks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TasksHandler {

    private final TaskService taskService;

    public TasksHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    public ResponseEntity<List<Tasks>> findAllTasks(int offset) {
        List<Tasks> tasks = taskService.findAllTasks(offset);
        return ResponseEntity.ok(tasks);
    }

    public ResponseEntity<String> totalTasks() {
        return ResponseEntity.ok("Total number of tasks: " + taskService.totalTasks());
    }

    public ResponseEntity<String> countAllTasks() {
        return ResponseEntity.ok("Total number of tasks completed: " + taskService.countAllTasks());
    }

    public ResponseEntity<PriorityTask> mediaPriority() {
        PriorityTask priorityTask = taskService.mediaPriority();
        return ResponseEntity.ok(priorityTask);
    }

    public ResponseEntity<Tasks> findById(int id_task) {
        Tasks taskDomain = taskService.findById(id_task);
        return ResponseEntity.ok(taskDomain);
    }

    public ResponseEntity<Tasks> insertTask(TaskCreateDTO taskCreate) {
        Tasks taskDomain = taskService.insertTask(taskCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskDomain);
    }

    public ResponseEntity<Tasks> updateTask(TaskUpdateDTO taskUpdate, int id_task) {
        Tasks taskDomain = taskService.updateTask(taskUpdate, id_task);
        return ResponseEntity.status(HttpStatus.OK).body(taskDomain);
    }

    public ResponseEntity<String> deleteTask(int id_task) {
        taskService.deleteTask(id_task);
        return ResponseEntity.noContent().build();
    }
}
