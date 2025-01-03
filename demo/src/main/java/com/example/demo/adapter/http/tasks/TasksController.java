package com.example.demo.adapter.http.tasks;

import com.example.demo.application.tasks.TaskCreateDTO;
import com.example.demo.application.tasks.TaskUpdateDTO;
import com.example.demo.domain.tasks.PriorityTask;
import com.example.demo.domain.tasks.Tasks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TasksHandler tasksHandler;

    public TasksController(TasksHandler tasksHandler) {
        this.tasksHandler = tasksHandler;
    }

    @GetMapping("/all/{offset}")
    public ResponseEntity<List<Tasks>> findAllTasks(@PathVariable String offset) {
        return tasksHandler.findAllTasks(offset);
    }

    @GetMapping("/count-all")
    public ResponseEntity<String> totalTasks() {
        return tasksHandler.totalTasks();
    }

    @GetMapping("/count-all-completed")
    public ResponseEntity<String> countAllTasks() {
        return tasksHandler.countAllTasks();
    }

    @GetMapping("/media-priority")
    public ResponseEntity<PriorityTask> mediaPriority() {
        return tasksHandler.mediaPriority();
    }

    @GetMapping("task")
    public ResponseEntity<Tasks> findById(@RequestParam("id_task") String id_task) {
        return tasksHandler.findById(id_task);
    }

    @PostMapping()
    public ResponseEntity<Tasks> insertTask(@RequestBody TaskCreateDTO taskCreate) {
        return tasksHandler.insertTask(taskCreate);
    }

    @PutMapping()
    public ResponseEntity<Tasks> updateTask(TaskUpdateDTO taskUpdate, String id_task) {
        return tasksHandler.updateTask(taskUpdate, id_task);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteTask(@RequestParam("id_task") String id_task) {
        return tasksHandler.deleteTask(id_task);
    }
}
