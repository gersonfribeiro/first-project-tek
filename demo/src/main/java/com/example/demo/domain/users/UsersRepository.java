package com.example.demo.domain.users;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;


// Classe repository para definir os contratos dos métodos
@Repository
public interface UsersRepository {

    // Retorna todos os usuários
    List<Users> findAllUsers(int offset);



    int countUsers();

    //  Buscar por um usuário com a id sendo o parâmetro
    Users findById(int id_user);

    //  Buscar por um usuário com o username sendo o parâmetro
    UserDetails findByUsername(String username);

    //  Buscar por um usuário com o email sendo o parâmetro, vai ser usado para imedir email duplicado
    UserDetails findByEmail(String email);

    // Create user
    Boolean insertUser(Users users);

    // Update user
    Boolean updateUser(Users users);

    // Delete user
    Boolean deleteUser(int id_user);
}
