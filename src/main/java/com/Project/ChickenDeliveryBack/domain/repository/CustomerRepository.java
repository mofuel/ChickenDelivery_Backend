package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.CustomerDTO;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    CustomerDTO save(CustomerDTO customerDTO);
    Optional<CustomerDTO> findById(Integer id);
    List<CustomerDTO> findAll();
    Optional<CustomerDTO> findByDni(String dni);
    void deleteById(Integer id);
}
