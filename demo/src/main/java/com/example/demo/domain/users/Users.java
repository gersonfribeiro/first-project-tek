package com.example.demo.domain.users;

import lombok.*;

import java.util.UUID;

// Essas marcações são do lombok e evitam o boilerplate no código
@Getter // Gera todos os métodos get dos atributos
@Setter // Gera todos os métodos set dos atributos
@AllArgsConstructor // Gera um construtor com todos os atributos
@NoArgsConstructor // Gera um construtor sem os atributos
public class Users {

    //  Atributos do objeto
    private String id_user;
    private String username;
    private String email;
    private String password;

    //    Construtor para a criação desse objeto com o endpoint POST, onde a id é gerada
    public Users(String username, String email, String password) {
        this.id_user = String.valueOf(UUID.randomUUID());
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
