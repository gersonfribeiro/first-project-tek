package com.example.demo.adapter.http.users;

import com.example.demo.application.users.UserService;
import com.example.demo.application.users.UsersCreateDTO;
import com.example.demo.application.users.UsersUpdateDTO;
import com.example.demo.domain.users.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsersHandler {

    private final UserService userService;

    public UsersHandler(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<List<Users>> findAllUsers(int offset) {
        List<Users> users = userService.findAllUsers(offset);
        return ResponseEntity.ok(users);
    }

    public ResponseEntity<Users> findByUsername(String username) {
        Users userDomain = userService.findByUsername(username);
        return ResponseEntity.ok(userDomain);
    }

    public ResponseEntity<Users> findByEmail(String email) {
        Users userDomain = userService.findByEmail(email);
        return ResponseEntity.ok(userDomain);
    }

    public ResponseEntity<Users> findById(int id_user) {
        Users userDomain = userService.findById(id_user);
        return ResponseEntity.ok(userDomain);
    }

    public ResponseEntity<Users> insertUser(UsersCreateDTO usersCreate) {
        Users usersDomain = userService.insertUser(usersCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body(usersDomain);
    }

    public ResponseEntity<Users> updateUser(UsersUpdateDTO userUpdate, int id_user) {
        Users userDomain = userService.updateUser(userUpdate, id_user);
        return ResponseEntity.status(HttpStatus.OK).body(userDomain);
    }

    public ResponseEntity<String> deleteUser(int id_user) {
        userService.deleteUser(id_user);
        return ResponseEntity.noContent().build();
    }
}
