package com.example.demo.domain.users;

public class Users {

    // Atributos do objeto
    private int id_user;
    private String username;
    private String email;
    private String passwordUser;

    // Construtor para a criação desse objeto com o endpoint POST, onde a id é gerada pelo banco
    public Users(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.passwordUser = password;
    }

    // Construtor para a edição desse objeto com o endpoint PUT, onde a id é passada
    public Users(int id_user, String username, String email, String password) {
        this.id_user = id_user;
        this.username = username;
        this.email = email;
        this.passwordUser = password;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id_user='" + id_user + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                '}';
    }
}
