package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.UserDTO;
import com.Project.ChickenDeliveryBack.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO save(UserDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario es obligatorio");
        }
        if (dto.getUsuario() == null || dto.getUsuario().isBlank()) {
            throw new IllegalArgumentException("El nombre de usuario es obligatorio");
        }
        if (dto.getRol() == null || dto.getRol().isBlank()) {
            throw new IllegalArgumentException("El rol es obligatorio");
        }
        dto.setUsuario(dto.getUsuario().trim().toLowerCase());
        if (userRepository.findByUsuario(dto.getUsuario()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un usuario con ese nombre de usuario");
        }
        if (dto.getEstado() == null) {
            dto.setEstado(true);
        }
        return userRepository.save(dto);
    }

    public Optional<UserDTO> findById(Integer id) {
        return userRepository.findById(id);
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserDTO> findByUsuario(String usuario) {
        return userRepository.findByUsuario(usuario);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
