package com.example.demo.adapter.jdbc.tasks;

public class SqlExpressionsTasks {

    // Consultar todas as tasks
    public static final String SELECT_ALL_TASKS = "SELECT * FROM tasks LIMIT 10 OFFSET :offset";

    // Consultar quantidade das tasks e retornar um valor inteiro
    public static final String SIZE_ALL_TASKS = "SELECT COUNT(*) FROM tasks";

    // Consultar tasks com o status concluído e retornar a quantidade de tasks
    public static final String SELECT_COMPLETED_TASKS_COUNT = "SELECT COUNT(*) FROM tasks WHERE statusTask = 'COMPLETED'";

    // Consulta que retorna um valor entre a média das prioridades dentre as tasks pendentes
    public static final String AVERAGE_TASKS_PENDING_PRIORITY =
            "SELECT AVG(CASE " +
                    "WHEN priority = 'LOW' THEN 1 " +
                    "WHEN priority = 'MEDIUM' THEN 2 " +
                    "WHEN priority = 'HIGH' THEN 3 " +
                    "END) AS average_priority " +
                    "FROM tasks " +
                    "WHERE statusTask = 'PENDING'";

    // Consultar task específica
    public static final String SELECT_TASK_BY_ID = "SELECT * FROM tasks WHERE id_task = :id_task";

    // Consulta sql para inserir uma nova task
    public static final String INSERT_TASK = "INSERT INTO tasks (id_task, title, descriptionTask, statusTask, priority, createdDate) VALUES (:id_task, :title, :descriptionTask, :statusTask, :priority, :createdDate)";

    // Consulta sql para editar uma task
    public static final String UPDATE_TASK = "UPDATE tasks SET title = :title, descriptionTask = :descriptionTask, statusTask = :statusTask, priority = :priority, createdDate = :createdDate WHERE id_task = :id_task";

    // Consulta sql para remover uma task
    public static final String DELETE_TASK = "DELETE FROM tasks WHERE id_task = :id_task";

    // Devolve o id do último registro
    public static final String LAST_TASK = "SELECT id_task FROM tasks ORDER BY id_task DESC LIMIT 1";

}
