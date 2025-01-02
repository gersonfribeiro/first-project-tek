package com.example.demo.adapter.jdbc.tasks;

public class SqlExpressionsTasks {

    // Consultar todas as tasks
    public static final String SELECT_ALL_TASKS = "SELECT * FROM tasks";

    // Consultar quantidade das tasks e retornar um valor inteiro
    public static final String SIZE_ALL_TASKS = "SELECT COUNT(*) FROM tasks";

    // Consultar tasks com o status concluído e retornar a quantidade de tasks
    public static final String SELECT_COMPLETED_TASKS_COUNT = "SELECT COUNT(*) FROM tasks WHERE status = 'FINISHED'";

    // Consultar task específica
    public static final String SELECT_TASK_BY_ID = "SELECT * FROM tasks WHERE id_task = ?";

    // Consulta sql para inserir uma nova task
    public static final String INSERT_TASK = "INSERT INTO tasks (id_task, title, descriptionTask, statusTask, priority, createdDate) VALUES (?, ?, ?, ?, ?, ?)";

    // Consulta sql para editar uma task
    public static final String UPDATE_TASK = "UPDATE tasks SET title = ?, descriptionTask = ?, statusTask = ?, priority = ?, createdDate = ? WHERE id_task = ?";

    // Consulta sql para remover uma task
    public static final String DELETE_TASK = "DELETE FROM tasks WHERE id_task = ?";

}
