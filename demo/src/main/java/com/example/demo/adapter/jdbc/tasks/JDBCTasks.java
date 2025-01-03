package com.example.demo.adapter.jdbc.tasks;

import com.example.demo.domain.tasks.PriorityTask;
import com.example.demo.domain.tasks.StatusTask;
import com.example.demo.domain.tasks.Tasks;
import com.example.demo.domain.tasks.TasksRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.example.demo.adapter.jdbc.tasks.SqlExpressionsTasks.*;

import java.util.Date;
import java.util.List;

@Repository
public class JDBCTasks implements TasksRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JDBCTasks(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // O rowMapper é responsável por mapear a resposta que da minha consulta sql e converter em um objeto
    private RowMapper<Tasks> tasksRowMapper() {
        return (rs, rowNum) -> {
            int id_task = Integer.parseInt(rs.getString("id_task"));
            String title = rs.getString("title");
            String descriptionTask = rs.getString("descriptionTask");
            StatusTask statusTask = StatusTask.valueOf(rs.getString("statusTask"));
            PriorityTask priority = PriorityTask.valueOf(rs.getString("priority"));
            Date createdDate = rs.getDate("created_date");

            return new Tasks(id_task, title, descriptionTask, statusTask, priority, createdDate);

        };
    }

    // O meu ParameterSource mapeia os parâmetros do objeto para uma consulta sql, insert por exemplo
    private MapSqlParameterSource tasksParameters(Tasks tasks) {
        return new MapSqlParameterSource()
                .addValue("id_task", tasks.getId_task())
                .addValue("title", tasks.getTitle())
                .addValue("descriptionTask", tasks.getDescriptionTask())
                .addValue("statusTask", tasks.getStatusTask().name())
                .addValue("priority", tasks.getPriority().name())
                .addValue("created_date", tasks.getCreatedDate());
    }

    @Override
    public List<Tasks> findAllTasks() {
        try {
            return jdbcTemplate.query(SELECT_ALL_TASKS, tasksRowMapper());
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int totalTasks() {
        try {
            List<Tasks> tasks = jdbcTemplate.query(SIZE_ALL_TASKS, tasksRowMapper());
            return tasks.size();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int countAllTasks() {
        try {
            jdbcTemplate.queryForObject(SELEC)
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public PriorityTask mediaPriority() {
        return null;
    }

    @Override
    public Tasks findById(int id_task) {
        return null;
    }

    @Override
    public Boolean saveTask(Tasks task) {
        return null;
    }

    @Override
    public Boolean updateTask(Tasks task) {
        return null;
    }

    @Override
    public Boolean deleteTask(int id_task) {
        return null;
    }
}
