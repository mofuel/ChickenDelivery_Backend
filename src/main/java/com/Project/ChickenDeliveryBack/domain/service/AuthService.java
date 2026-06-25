package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.config.JwtUtil;
import com.Project.ChickenDeliveryBack.domain.dto.AuthRequest;
import com.Project.ChickenDeliveryBack.domain.dto.AuthResponse;
import com.Project.ChickenDeliveryBack.persistence.crud.UserCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserCrudRepository userCrudRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public AuthService(UserCrudRepository userCrudRepository, JwtUtil jwtUtil) {
        this.userCrudRepository = userCrudRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public AuthResponse login(AuthRequest request) {
        if (request.getUsuario() == null || request.getUsuario().isBlank()) {
            throw new IllegalArgumentException("El usuario es obligatorio");
        }
        if (request.getContrasenia() == null || request.getContrasenia().isBlank()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }

        User user = userCrudRepository.findByUsuario(request.getUsuario().trim().toLowerCase())
                .orElseThrow(() -> new IllegalArgumentException("Usuario o contraseña incorrectos"));

        if (!passwordEncoder.matches(request.getContrasenia(), user.getContrasenia())) {
            throw new IllegalArgumentException("Usuario o contraseña incorrectos");
        }

        if (!user.getEstado()) {
            throw new IllegalArgumentException("Usuario inactivo");
        }

        String token = jwtUtil.generateToken(user.getId(), user.getUsuario(), user.getRol());
        return new AuthResponse(token, user.getId(), user.getNombre(), user.getUsuario(), user.getRol());
    }

    public AuthResponse register(AuthRequest request) {
        if (request.getUsuario() == null || request.getUsuario().isBlank()) {
            throw new IllegalArgumentException("El usuario es obligatorio");
        }
        if (request.getContrasenia() == null || request.getContrasenia().isBlank()) {
            throw new IllegalArgumentException("La contraseña es obligatoria");
        }

        String usuario = request.getUsuario().trim().toLowerCase();

        if (userCrudRepository.findByUsuario(usuario).isPresent()) {
            throw new IllegalArgumentException("Ya existe un usuario con ese nombre");
        }

        User user = new User();
        user.setNombre(usuario);
        user.setUsuario(usuario);
        user.setContrasenia(passwordEncoder.encode(request.getContrasenia()));
        user.setRol("VENDEDOR");
        user.setEstado(true);

        User saved = userCrudRepository.save(user);

        String token = jwtUtil.generateToken(saved.getId(), saved.getUsuario(), saved.getRol());
        return new AuthResponse(token, saved.getId(), saved.getNombre(), saved.getUsuario(), saved.getRol());
    }
}
