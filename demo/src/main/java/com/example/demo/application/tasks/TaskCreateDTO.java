package com.example.demo.application.tasks;

import com.example.demo.domain.tasks.PriorityTask;
import com.example.demo.domain.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskCreateDTO {

    @JsonProperty("title")
    private String title;

    @JsonProperty("descriptionTask")
    private String descriptionTask;

    @JsonProperty("priority")
    private PriorityTask priority;

    public Tasks toTasks() {
        return new Tasks(title, descriptionTask, priority);
    }
}
