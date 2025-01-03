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
        return usersRepository.findAllUsers(offset);
    }

    public Users findByUsername(String username) {
        Users userDomain = usersRepository.findByUsername(username);
        if (userDomain == null)
            throw new RuntimeException("A user was not found for the username: " + username);

        return userDomain;
    }

    public Users findById(int id_user) {
        Users userDomain = usersRepository.findById(id_user);
        if (userDomain == null)
            throw new RuntimeException("A user was not found for the id: " + id_user);

        return userDomain;
    }

    public Boolean insertUser(UsersCreateDTO usersCreate) {
        Users usersDomain = usersCreate.toUser();
        return usersRepository.insertUser(usersDomain);
    }

    public Boolean updateUser(UsersUpdateDTO userUpdate, int id_user) {
        if (usersRepository.findById(id_user) == null)
            throw new RuntimeException("User not found");

        Users userDomain = userUpdate.toUser(id_user);
        return usersRepository.updateUser(userDomain);
    }

    public Boolean deleteUser(int id_user) {
        if (usersRepository.findById(id_user) == null)
            throw new RuntimeException("User not found");
        return usersRepository.deleteUser(id_user);
    }
}
