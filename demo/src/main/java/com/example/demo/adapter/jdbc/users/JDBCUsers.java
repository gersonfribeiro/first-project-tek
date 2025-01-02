package com.example.demo.adapter.jdbc.users;

import com.example.demo.domain.users.Users;
import com.example.demo.domain.users.UsersRepository;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.example.demo.adapter.jdbc.users.SqlExpressionsUsers.*;

import java.util.List;

@Repository
public class JDBCUsers implements UsersRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JDBCUsers(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    // O rowMapper é responsável por mapear a resposta que da minha consulta sql e converter em um objeto
    private RowMapper<Users> usersRowMapper() {
        return (rs, rowNum) -> {
            String id_user = rs.getString("id_user");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String password = rs.getString("password");

            return new Users(id_user, username, email, password);
        };
    }

    // O meu ParameterSource mapeia os parâmetros do objeto para uma consulta sql, insert por exemplo
    private MapSqlParameterSource mapSqlParameterSource(Users users) {
        return new MapSqlParameterSource()
                .addValue("id_user", users.getId_user())
                .addValue("username", users.getUsername())
                .addValue("email", users.getEmail())
                .addValue("password", users.getPassword());
    }

    // Implementação da consulta de todos os usuários, retornando em uma lista
    @Override
    public List<Users> findAllUsers() {
        List<Users> usuarios;
        try {
            return jdbcTemplate.query(sqlSelectAllUsers, usersRowMapper());
        } catch (Exception e) {
//            LOGGER.error(e.getMessage());
            throw e;
        }
    }

    // Implementação da consulta de usuario por id, armazenado em uma lista mas exibindo apenas o primeiro
    @Override
    public Users findById(String id_user) {
        List<Users> usuarios;
        try {
            MapSqlParameterSource parameters = new MapSqlParameterSource("id_user", id_user);
            usuarios = jdbcTemplate.query(sqlSelectUserById, parameters, usersRowMapper());
            return usuarios.isEmpty() ? null : usuarios.getFirst();
        } catch (Exception e) {
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
            throw e;
        }
    }

    // Implementação da inserção de usuario
    @Override
    public Boolean saveUser(Users users) {
        try {
            MapSqlParameterSource params = mapSqlParameterSource(users);
            return jdbcTemplate.update(sqlInsertUser, params) > 0;
        } catch (Exception e) {
            throw e;
        }
    }

    // Implementação da edição de usuario
    @Override
    public Boolean updateUser(Users users) {
        try {
            MapSqlParameterSource params = mapSqlParameterSource(users);
            return jdbcTemplate.update(sqlEditarUser, params) > 0;
        } catch (Exception e) {
            throw e;
        }
    }

    // Implementação da remoção de usuario
    @Override
    public Boolean deleteUser(String id_user) {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource("id_user", id_user);
            return jdbcTemplate.update(sqlDeleteUser, params) > 0;
        } catch (Exception e) {
            throw e;
        }
    }
}
