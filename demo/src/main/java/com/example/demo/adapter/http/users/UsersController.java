package com.example.demo.adapter.http.users;

import com.example.demo.application.users.UsersCreateDTO;
import com.example.demo.application.users.UsersUpdateDTO;
import com.example.demo.domain.users.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersHandler usersHandler;

    public UsersController(UsersHandler usersHandler) {
        this.usersHandler = usersHandler;
    }

    @GetMapping("all")
    public ResponseEntity<List<Users>> findAllUsers(@RequestParam String offset) {
        return usersHandler.findAllUsers(offset);
    }

    @GetMapping("username")
    public ResponseEntity<Users> findByUsername(@RequestParam String username) {
        return usersHandler.findByUsername(username);
    }

    @GetMapping("email")
    public ResponseEntity<Users> findByEmail(@RequestParam String email) {
        return usersHandler.findByEmail(email);
    }

    @GetMapping("user")
    public ResponseEntity<Users> findById(@RequestParam String id_user) {
        return usersHandler.findById(id_user);
    }

    @PostMapping()
    public ResponseEntity<Users> insertUser(@RequestBody UsersCreateDTO usersCreate) {
        return usersHandler.insertUser(usersCreate);
    }

    @PutMapping()
    public ResponseEntity<Users> updateUser(@RequestBody UsersUpdateDTO userUpdate, @RequestParam String id_user) {
        return usersHandler.updateUser(userUpdate, id_user);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteUser(@RequestParam String id_user) {
        return usersHandler.deleteUser(id_user);
    }

}
