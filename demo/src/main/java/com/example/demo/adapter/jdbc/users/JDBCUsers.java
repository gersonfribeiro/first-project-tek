package com.example.demo.adapter.jdbc.users;

import com.example.demo.adapter.http.allErrors.ErrorHandler;
import com.example.demo.domain.users.Users;
import com.example.demo.domain.users.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.example.demo.adapter.jdbc.tasks.SqlExpressionsTasks.SIZE_ALL_TASKS;
import static com.example.demo.adapter.jdbc.users.SqlExpressionsUsers.*;

import java.util.List;

@Repository
public class JDBCUsers implements UsersRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JDBCUsers(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    // O rowMapper é responsável por mapear a resposta que da minha consulta sql e converter em um objeto
    private RowMapper<Users> usersRowMapper() {
        return (rs, rowNum) -> {
            int id_user = Integer.parseInt(rs.getString("id_user"));
            String username = rs.getString("username");
            String email = rs.getString("email");
            String passwordUser = rs.getString("passwordUser");

            return new Users(id_user, username, email, passwordUser);
        };
    }

    // O meu ParameterSource mapeia os parâmetros do objeto para uma consulta sql, insert por exemplo
    private MapSqlParameterSource usersParameters(Users users) {
        return new MapSqlParameterSource()
                .addValue("id_user", users.getId_user())
                .addValue("username", users.getUsername())
                .addValue("email", users.getEmail())
                .addValue("passwordUser", users.getPasswordUser());
    }

    // Implementação da consulta de todos os usuários, retornando em uma lista
    @Override
    public List<Users> findAllUsers(int offset) {
        try {
            // Garante que o valor mínimo do OFFSET será 0
            offset = Math.max((offset - 1) * 10, 0);
            MapSqlParameterSource parameters = new MapSqlParameterSource("offset", offset);
            return jdbcTemplate.query(sqlSelectAllUsers, parameters, usersRowMapper());
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public int countUsers() {
        try {
            Integer totalTask = jdbcTemplate.queryForObject(sqlSizeAllTasks, new MapSqlParameterSource(), Integer.class);
            return (totalTask != null) ? totalTask : 0;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    // Implementação da consulta de usuario por id, armazenado em uma lista mas exibindo apenas o primeiro
    @Override
    public Users findById(int id_user) {
        List<Users> usuarios;
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource("id_user", id_user);
            usuarios = jdbcTemplate.query(sqlSelectUserById, parameters, usersRowMapper());
            return usuarios.isEmpty() ? null : usuarios.getFirst();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    // Implementação da consulta de usuario por username, armazenado em uma lista mas exibindo apenas o primeiro
    @Override
    public Users findByUsername(String username) {
        List<Users> usuarios;
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource("username", username);
            usuarios = jdbcTemplate.query(sqlSelectUserByUsername, parameters, usersRowMapper());
            return usuarios.isEmpty() ? null : usuarios.getFirst();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    // Implementação da consulta de usuario por email, armazenado em uma lista mas exibindo apenas o primeiro
    @Override
    public Users findByEmail(String email) {
        List<Users> usuarios;
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource("email", email);
            usuarios = jdbcTemplate.query(sqlSelectUserByEmail, parameters, usersRowMapper());
            return usuarios.isEmpty() ? null : usuarios.getFirst();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    // Implementação da inserção de usuario
    @Override
    public Boolean insertUser(Users users) {
        try {
            MapSqlParameterSource params = usersParameters(users);
            return jdbcTemplate.update(sqlInsertUser, params) > 0;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    // Implementação da edição de usuario
    @Override
    public Boolean updateUser(Users users) {
        try {
            MapSqlParameterSource params = usersParameters(users);
            return jdbcTemplate.update(sqlEditarUser, params) > 0;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    // Implementação da remoção de usuario
    @Override
    public Boolean deleteUser(int id_user) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource("id_user", id_user);
            return jdbcTemplate.update(sqlDeleteUser, params) > 0;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            throw e;
        }
    }
}
