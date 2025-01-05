package com.example.demo.adapter.jdbc.users;

public class SqlExpressionsUsers {

    //  Consulta sql para retornar todos os usuários
    public static final String sqlSelectAllUsers = "SELECT * FROM users LIMIT 10 OFFSET :offset";

    public static final String sqlSizeAllTasks = "SELECT COUNT(*) FROM users";

    // Consulta sql para retornar um usuário com o parâmetro id
    public static final String sqlSelectUserById = "SELECT * FROM users WHERE id_user = :id_user";

    // Consulta sql para retornar um usuário com o parâmetro username
    public static final String sqlSelectUserByUsername = "SELECT * FROM users WHERE username = :username";

    // Consulta sql para retornar um usuário com o parâmetro email
    public static final String sqlSelectUserByEmail = "SELECT * FROM users WHERE email = :email";

    // Consulta sql para inserir um usuário
    public static final String sqlInsertUser = "INSERT INTO users (id_user, username, email, passwordUser) VALUES (:id_user, :username, :email, :passwordUser)";

    // Consulta sql para editar um usuário
    public static final String sqlEditarUser = "UPDATE users SET username = :username, email = :email, passwordUser = :passwordUser WHERE id_user = :id_user";

    // Consulta sql para remover um usuário
    public static final String sqlDeleteUser = "DELETE FROM users WHERE id_user = :id_user";
}
