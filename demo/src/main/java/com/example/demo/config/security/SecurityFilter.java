//package com.example.demo.config.security;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class SecurityFilter extends OncePerRequestFilter {
//
//    @Autowired
//    TokenService tokenService;
//    @Autowired
//    UsuariosRepository usuariosRepository;
//
//    @SuppressWarnings("null")
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        var token = this.recoverToken(request);
//        if (token != null) {
//            var subject = tokenService.validateToken(token);
//            Optional<UserDetails> usuario = usuariosRepository.findByEmail(subject);
//
//            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.get().getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//        filterChain.doFilter(request, response);
//    }
//
//    private String recoverToken(HttpServletRequest request) {
//        var authHeader = request.getHeader("Authorization");
//        if (authHeader == null)
//            return null;
//        return authHeader.replace("Bearer ", "");
//    }
//}
