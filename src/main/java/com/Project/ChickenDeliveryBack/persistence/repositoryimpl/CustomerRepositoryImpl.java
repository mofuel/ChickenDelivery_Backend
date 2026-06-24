package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.CustomerDTO;
import com.Project.ChickenDeliveryBack.domain.repository.CustomerRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.CustomerCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.CustomerMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerCrudRepository crudRepository;
    private final CustomerMapper mapper;

    public CustomerRepositoryImpl(CustomerCrudRepository crudRepository, CustomerMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(customerDTO)));
    }

    @Override
    public Optional<CustomerDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<CustomerDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDTO> findByDni(String dni) {
        return crudRepository.findByDni(dni).map(mapper::toDto);
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
