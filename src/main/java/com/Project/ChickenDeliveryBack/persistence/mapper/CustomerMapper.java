package com.Project.ChickenDeliveryBack.persistence.mapper;

import com.Project.ChickenDeliveryBack.domain.dto.CustomerDTO;
import com.Project.ChickenDeliveryBack.persistence.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDTO toDto(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
}