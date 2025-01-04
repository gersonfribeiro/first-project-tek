package com.example.demo.application.tasks;

import com.example.demo.domain.tasks.PriorityTask;
import com.example.demo.domain.tasks.Tasks;
import com.example.demo.domain.tasks.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Tasks> findAllTasks(int offset) {
        return tasksRepository.findAllTasks(offset);
    }

    public int totalTasks() {
        return tasksRepository.totalTasks();
    }

    public int countAllTasks() {
        return tasksRepository.countAllTasks();
    }

    public PriorityTask mediaPriority() {
        return tasksRepository.mediaPriority();
    }

    public Tasks findById(int id_task) throws RuntimeException {
        Tasks tasksDomain = tasksRepository.findById(id_task);
        if (tasksDomain == null)
            throw new RuntimeException("Task not found");

        return tasksDomain;
    }

    public Tasks insertTask(TaskCreateDTO taskCreate) {
        Tasks tasksDomain =  taskCreate.toTasks();
        tasksRepository.insertTask(tasksDomain);
        tasksDomain.setId_task(totalTasks());
        return tasksDomain;
    }

    public Tasks updateTask(TaskUpdateDTO taskUpdate, int id_task) {
        if (tasksRepository.findById(id_task) == null)
            throw new RuntimeException("Task not found");

        Tasks tasksDomain =  taskUpdate.toTasks(id_task);
        tasksRepository.updateTask(tasksDomain);
        return findById(id_task);
    }

    public void deleteTask(int id_task) {
        if (tasksRepository.findById(id_task) == null)
            throw new RuntimeException("Task not found");
        tasksRepository.deleteTask(id_task);
    }
}
