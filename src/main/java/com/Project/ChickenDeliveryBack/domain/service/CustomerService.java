package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.CustomerDTO;
import com.Project.ChickenDeliveryBack.domain.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDTO save(CustomerDTO dto) {
        if (dto.getNombre() == null || dto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        dto.setNombre(dto.getNombre().trim());
        if (dto.getDni() != null && !dto.getDni().isBlank()) {
            dto.setDni(dto.getDni().trim());
            if (customerRepository.findByDni(dto.getDni()).isPresent()) {
                throw new IllegalArgumentException("Ya existe un cliente con ese DNI");
            }
        }
        if (dto.getFechaRegistro() == null) {
            dto.setFechaRegistro(LocalDateTime.now());
        }
        if (dto.getEstado() == null) {
            dto.setEstado(true);
        }
        return customerRepository.save(dto);
    }

    public Optional<CustomerDTO> findById(Integer id) {
        return customerRepository.findById(id);
    }

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll();
    }

    public Optional<CustomerDTO> findByDni(String dni) {
        return customerRepository.findByDni(dni);
    }

    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }
}
