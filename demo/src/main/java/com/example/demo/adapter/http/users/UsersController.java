package com.example.demo.adapter.http.users;

import com.example.demo.application.users.AuthenticationDTO;
import com.example.demo.application.users.LoginResponseDTO;
import com.example.demo.application.users.UsersCreateDTO;
import com.example.demo.application.users.UsersUpdateDTO;
import com.example.demo.config.security.TokenService;
import com.example.demo.domain.users.Users;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    private static final Logger log = LoggerFactory.getLogger(UsersController.class);
    private final UsersHandler usersHandler;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public UsersController(UsersHandler usersHandler, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.usersHandler = usersHandler;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmailUser(), data.getPasswordUser());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Users) auth.getPrincipal());

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO(token);
        return ResponseEntity.ok(loginResponseDTO);
    }

    @GetMapping("all")
    public ResponseEntity<List<Users>> findAllUsers(@RequestParam("offset") String offset) {
        return usersHandler.findAllUsers(offset);
    }

    @GetMapping("count-all-users")
    public ResponseEntity<String> countUsers() {
        return usersHandler.countUsers();
    }

    @GetMapping("username")
    public ResponseEntity<Users> findByUsername(@RequestParam("username") String username) {
        return usersHandler.findByUsername(username);
    }

    @GetMapping("email")
    public ResponseEntity<UserDetails> findByEmail(@RequestParam("email") String email) {
        return usersHandler.findByEmail(email);
    }

    @GetMapping("user")
    public ResponseEntity<Users> findById(@RequestParam("id_user") String id_user) {
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
    public ResponseEntity<String> deleteUser(@RequestParam("id_user") String id_user) {
        return usersHandler.deleteUser(id_user);
    }

}
