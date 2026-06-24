package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.ProductCategoryDTO;
import com.Project.ChickenDeliveryBack.domain.repository.ProductCategoryRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.ProductCategoryCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.ProductCategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductCategoryRepositoryImpl implements ProductCategoryRepository {

    private final ProductCategoryCrudRepository crudRepository;
    private final ProductCategoryMapper mapper;

    public ProductCategoryRepositoryImpl(ProductCategoryCrudRepository crudRepository, ProductCategoryMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public ProductCategoryDTO save(ProductCategoryDTO productCategoryDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(productCategoryDTO)));
    }

    @Override
    public Optional<ProductCategoryDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<ProductCategoryDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductCategoryDTO> findByNombre(String nombre) {
        return crudRepository.findByNombre(nombre).map(mapper::toDto);
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}