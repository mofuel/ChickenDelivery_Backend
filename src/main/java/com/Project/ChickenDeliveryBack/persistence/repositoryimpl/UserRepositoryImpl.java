package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.UserDTO;
import com.Project.ChickenDeliveryBack.domain.repository.UserRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.UserCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserCrudRepository crudRepository;
    private final UserMapper mapper;

    public UserRepositoryImpl(UserCrudRepository crudRepository, UserMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(userDTO)));
    }

    @Override
    public Optional<UserDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<UserDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDTO> findByUsuario(String usuario) {
        return crudRepository.findByUsuario(usuario).map(mapper::toDto);
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
