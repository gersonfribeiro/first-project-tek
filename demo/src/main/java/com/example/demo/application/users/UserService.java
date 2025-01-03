package com.example.demo.application.users;

import com.example.demo.domain.users.Users;
import com.example.demo.domain.users.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> findAllUsers(int offset) {
        offset = (offset - 1) * 10;
        return usersRepository.findAllUsers(offset);
    }

    public Users findByUsername(String username) {
        Users userDomain = usersRepository.findByUsername(username);
        if (userDomain == null)
            throw new RuntimeException("A user was not found for the username: " + username);

        return userDomain;
    }

    public Users findByEmail(String email) {
        Users userDomain = usersRepository.findByEmail(email);
        if (userDomain == null)
            throw new RuntimeException("A user was not found for the email: " + email);

        return userDomain;
    }

    public Users findById(int id_user) {
        Users userDomain = usersRepository.findById(id_user);
        if (userDomain == null)
            throw new RuntimeException("A user was not found for the id: " + id_user);

        return userDomain;
    }

    public Users insertUser(UsersCreateDTO usersCreate) {
        Users usersDomain = usersCreate.toUser();
        if (usersRepository.findByEmail(usersDomain.getEmail()) != null)
            throw new RuntimeException("The email is already in use");
        usersRepository.insertUser(usersDomain);
        return findById(usersDomain.getId_user());
    }

    public Users updateUser(UsersUpdateDTO userUpdate, int id_user) {
        if (usersRepository.findById(id_user) == null)
            throw new RuntimeException("User not found");

        Users userDomain = userUpdate.toUser(id_user);
        usersRepository.updateUser(userDomain);
        return findById(id_user);
    }

    public void deleteUser(int id_user) {
        if (usersRepository.findById(id_user) == null)
            throw new RuntimeException("User not found");
        usersRepository.deleteUser(id_user);
    }
}
