package com.example.demo.application.users;

import com.example.demo.application.users.exceptions.UsuarioEmailCadastradoException;
import com.example.demo.application.users.exceptions.UsuarioEmailNaoEncontradoException;
import com.example.demo.application.users.exceptions.UsuarioNaoEncontradoException;
import com.example.demo.application.users.exceptions.UsuarioNaoEncontradoUsernameException;
import com.example.demo.domain.users.Users;
import com.example.demo.domain.users.UsersRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    // Busca todos os usuários com paginação, offset é a página
    public List<Users> findAllUsers(int offset) {
        return usersRepository.findAllUsers(offset);
    }

    // Retorna o último id de usuários
    public int idLastUsers() {
        return usersRepository.idLastUser();
    }

    // Retorna a quantidade de usuários totais
    public int countUsers() {
        return usersRepository.countUsers();
    }

    // Busca um usuário pelo seu username
    public Users findByUsername(String username) {
        Users userDomain = usersRepository.findByUsername(username);
        // valida se existe um usuário com o username inserido
        if (userDomain == null)
            // Exception personalizada em caso de não encontrar
            throw new UsuarioNaoEncontradoUsernameException(username);
        return userDomain;
    }

    // Busca um usuário pelo seu email
    public UserDetails findByEmail(String email) {
        // Armazena a resposta do método em um objeto do domínio
        UserDetails userDomain = usersRepository.findByEmail(email);
        // Validação se o usuário existe
        if (userDomain == null)
            // Exception personalizada em caso de not found
            throw new UsuarioEmailNaoEncontradoException(email);
        return userDomain;
    }

    // Busca um usuário pelo seu id
    public Users findById(int id_user) throws RuntimeException {
        // Armazena a resposta do método em um objeto do domínio
        Users userDomain = usersRepository.findById(id_user);
        // Validação se o usuário existe
        if (userDomain == null)
            // Exception personalizada em caso de not found
            throw new UsuarioNaoEncontradoException();
        return userDomain;
    }

    public Users insertUser(UsersCreateDTO usersCreate) {
        // Converte o dto em um usuário do domínio
        Users userDomain = usersCreate.toUser();
        // Armazena o email para validação
        String emailUsuario = userDomain.getEmail();
        // Valida se o email está em uso
        if (usersRepository.findByEmail(emailUsuario) != null)
            // Exception personalizada para email duplicado
            throw new UsuarioEmailCadastradoException(emailUsuario);
        // Chama o método que insere os dados no banco
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDomain.getPassword());
        userDomain.setPasswordUser(encryptedPassword);
        usersRepository.insertUser(userDomain);
        // Esse método é apenas para informar o id no retorno,
        // como a responsabilidade é do banco de auto incrementar, não sabemos o id
        userDomain.setId_user(idLastUsers());
        return userDomain;
    }

    public Users updateUser(UsersUpdateDTO userUpdate, int id_user) {
        // Armazena o usuário antes da modificação
        Users userBefore = usersRepository.findById(id_user);
        // Verificação se o usuário existe para o id do parâmetro
        if (userBefore == null)
            // Exception personalisada em caso de um not found
            throw new UsuarioNaoEncontradoException();
        // Converte o dto em um usuário da classe de domínio
        Users userDomain = userUpdate.toUser(id_user);
        // Armazena o email para validação
        String emailUsuario = userDomain.getEmail();
        // Valida se o email já está em uso e se foi modificado, se permanecer o mesmo, permite o update
        if (usersRepository.findByEmail(emailUsuario) != null && !Objects.equals(emailUsuario, userBefore.getEmail()))
            throw new UsuarioEmailCadastradoException(emailUsuario);

        // também é possível modificar a senha, encode também deve ser feito
        String encryptedPassword = new BCryptPasswordEncoder().encode(userDomain.getPassword());
        userDomain.setPasswordUser(encryptedPassword);

        // Após passar pelas validações enfim chama o método que atualiza os dados do usuário
        usersRepository.updateUser(userDomain);
        return findById(id_user);
    }

    public void deleteUser(int id_user) {
        // Validação se o usuário existe para o id
        if (usersRepository.findById(id_user) == null)
            // Exception personalizada em caso de not found
            throw new UsuarioNaoEncontradoException();
        usersRepository.deleteUser(id_user);
    }
}
