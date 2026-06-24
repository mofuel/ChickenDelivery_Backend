package com.Project.ChickenDeliveryBack.persistence.crud;

import com.Project.ChickenDeliveryBack.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerCrudRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByDni(String dni);
}
