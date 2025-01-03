package com.example.demo.application.tasks;

import com.example.demo.domain.tasks.PriorityTask;
import com.example.demo.domain.tasks.StatusTask;
import com.example.demo.domain.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskUpdateDTO {

    @JsonProperty("title")
    private String title;

    @JsonProperty("descriptionTask")
    private String descriptionTask;

    @JsonProperty("statusTask")
    private StatusTask statusTask;

    @JsonProperty("priority")
    private PriorityTask priority;

    public Tasks toTasks(int id_task) {
        return new Tasks(id_task, title, descriptionTask, statusTask, priority);
    }
}
