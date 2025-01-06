package com.example.demo.adapter.jdbc.users;

public class SqlExpressionsUsers {

    //  Consulta sql para retornar todos os usuários
    public static final String sqlSelectAllUsers = "SELECT * FROM users LIMIT 10 OFFSET :offset";

    public static final String sqlSizeAllTasks = "SELECT COUNT(*) FROM users";

    // Consulta sql para retornar um usuário com o parâmetro id
    public static final String sqlSelectUserById = "SELECT * FROM users WHERE id_user = :id_user";

    // Consulta sql para retornar um usuário com o parâmetro username
    public static final String sqlSelectUserByUsername = "SELECT * FROM users WHERE usernameUser = :usernameUser";

    // Consulta sql para retornar um usuário com o parâmetro email
    public static final String sqlSelectUserByEmail = "SELECT * FROM users WHERE email = :email";

    // Consulta sql para inserir um usuário
    public static final String sqlInsertUser = "INSERT INTO users (id_user, usernameUser, email, passwordUser) VALUES (:id_user, :usernameUser, :email, :passwordUser)";

    // Consulta sql para editar um usuário
    public static final String sqlEditarUser = "UPDATE users SET usernameUser = :usernameUser, email = :email, passwordUser = :passwordUser WHERE id_user = :id_user";

    // Consulta sql para remover um usuário
    public static final String sqlDeleteUser = "DELETE FROM users WHERE id_user = :id_user";

    // Devolve o id do último registro
    public static final String sqlLastUser = "SELECT id_user FROM users ORDER BY id_user DESC LIMIT 1";
}
