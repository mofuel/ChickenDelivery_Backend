package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.PromotionDTO;
import com.Project.ChickenDeliveryBack.domain.repository.PromotionRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.PromotionCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.PromotionMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PromotionRepositoryImpl implements PromotionRepository {

    private final PromotionCrudRepository crudRepository;
    private final PromotionMapper mapper;

    public PromotionRepositoryImpl(PromotionCrudRepository crudRepository, PromotionMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public PromotionDTO save(PromotionDTO promotionDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(promotionDTO)));
    }

    @Override
    public Optional<PromotionDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<PromotionDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PromotionDTO> findByCodigo(String codigo) {
        return crudRepository.findByCodigo(codigo).map(mapper::toDto);
    }

    @Override
    public List<PromotionDTO> findByEstado(Boolean estado) {
        return crudRepository.findByEstado(estado).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
