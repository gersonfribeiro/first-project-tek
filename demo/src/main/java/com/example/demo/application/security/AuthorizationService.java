//package com.example.demo.application.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthorizationService implements UserDetailsService {
//
//    @Autowired
//    UsuariosRepository usuariosRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        return usuariosRepository.findByEmail(email).
//                orElseThrow(() -> new UsernameNotFoundException("Usuario não encontrado para o e-mail: " + email));
//    }
//}
