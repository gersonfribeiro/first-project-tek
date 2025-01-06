package com.example.demo.domain.users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Users implements UserDetails {

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
        return email;
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

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

}
