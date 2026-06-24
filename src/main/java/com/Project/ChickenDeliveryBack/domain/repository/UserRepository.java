package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    UserDTO save(UserDTO userDTO);
    Optional<UserDTO> findById(Integer id);
    List<UserDTO> findAll();
    Optional<UserDTO> findByUsuario(String usuario);
    void deleteById(Integer id);
}
