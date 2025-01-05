//package com.example.demo.config.security;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneOffset;
//
//@Service
//public class TokenService {
//
//    @Value("${DOTENV_JWT_SECRECT:my-secret-key}")
//    private String secret;
//
//    public String generateToken(Usuarios usuario) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            return JWT.create()
//                    .withIssuer("plataforma")
//                    .withSubject(usuario.getEmail())
//                    .withExpiresAt(genExpirationDate())
//                    .sign(algorithm);
//        } catch (JWTCreationException e) {
//            throw new RuntimeException("Erro ao gerar o token", e);
//        }
//    }
//
//    public String validateToken(String token) {
//        try {
//
//            Algorithm algorithm = Algorithm.HMAC256(secret);
//            return JWT.require(algorithm)
//                    .withIssuer("plataforma")
//                    .build()
//                    .verify(token)
//                    .getSubject();
//        } catch (JWTVerificationException e) {
//            return "";
//        }
//    }
//
//    private Instant genExpirationDate() {
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//    }
//}
