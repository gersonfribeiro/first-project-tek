package com.example.demo.domain.tasks;

import java.util.Date;

public class Tasks {

    // Atributos do objeto
    private int id_task;
    private String title;
    private String descriptionTask;
    private StatusTask statusTask;
    private PriorityTask priority;
    private Date createdDate;

    // Construtor para a criação desse objeto com o endpoint POST, onde a id é gerada pelo banco e a data é a obtida pelo sistema
    public Tasks(String title, String description, PriorityTask priority) {
        this.title = title;
        this.descriptionTask = description;
        this.statusTask = StatusTask.PENDING;
        this.priority = priority;
        // Aqui é usado uma métodoo para receber a data atual e setar sempre que esse métodoo construtor for usado
        this.createdDate = java.util.Date.from(java.time.LocalDate.now()
                .atStartOfDay(java.time.ZoneId.of("UTC"))
                .toInstant());
    }

    // Construtor para update desse objeto com o endpoint PUT, onde a id e o status são passados e a data é obtida pelo sistema
    public Tasks(int id_task, String title, String description, StatusTask statusTask, PriorityTask priority) {
        this.id_task = id_task;
        this.title = title;
        this.descriptionTask = description;
        this.statusTask = statusTask;
        this.priority = priority;
        // Aqui é usado uma métodoo para receber a data atual e setar sempre que esse métodoo construtor for usado
        this.createdDate = java.util.Date.from(java.time.LocalDate.now()
                .atStartOfDay(java.time.ZoneId.of("UTC"))
                .toInstant());
    }

    // Construtor com todos os argumentos para o RowMapper
    public Tasks(int id_task, String title, String descriptionTask, StatusTask statusTask, PriorityTask priority, Date createdDate) {
        this.id_task = id_task;
        this.title = title;
        this.descriptionTask = descriptionTask;
        this.statusTask = statusTask;
        this.priority = priority;
        this.createdDate = createdDate;
    }

    public int getId_task() {
        return id_task;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionTask() {
        return descriptionTask;
    }

    public void setDescriptionTask(String descriptionTask) {
        this.descriptionTask = descriptionTask;
    }

    public StatusTask getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(StatusTask statusTask) {
        this.statusTask = statusTask;
    }

    public PriorityTask getPriority() {
        return priority;
    }

    public void setPriority(PriorityTask priority) {
        this.priority = priority;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id_task='" + id_task + '\'' +
                ", title='" + title + '\'' +
                ", descriptionTask='" + descriptionTask + '\'' +
                ", statusTask=" + statusTask +
                ", priority=" + priority +
                ", createdDate=" + createdDate +
                '}';
    }
}
