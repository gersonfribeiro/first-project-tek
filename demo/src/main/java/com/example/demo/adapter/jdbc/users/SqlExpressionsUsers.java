package com.example.demo.adapter.jdbc.users;

public class SqlExpressionsUsers {

    //  Consulta sql para retornar todos os usuários
    public static final String sqlSelectAllUsers = "SELECT * FROM users LIMIT 10 OFFSET :offset";

    // Consulta sql para retornar um usuário com o parâmetro id
    public static final String sqlSelectUserById = "SELECT * FROM users WHERE id_user = ?";

    // Consulta sql para retornar um usuário com o parâmetro username
    public static final String sqlSelectUserByUsername = "SELECT * FROM users WHERE username = ?";

    // Consulta sql para retornar um usuário com o parâmetro email
    public static final String sqlSelectUserByEmail = "SELECT * FROM users WHERE email = ?";

    // Consulta sql para inserir um usuário
    public static final String sqlInsertUser = "INSERT INTO users (id_user, username, email, passwordUser) VALUES (?, ?, ?, ?)";

    // Consulta sql para editar um usuário
    public static final String sqlEditarUser = "UPDATE users SET username = ?, email = ?, passwordUser = ? WHERE id_user = ?";

    // Consulta sql para remover um usuário
    public static final String sqlDeleteUser = "DELETE FROM users WHERE id_user = ?";
}
