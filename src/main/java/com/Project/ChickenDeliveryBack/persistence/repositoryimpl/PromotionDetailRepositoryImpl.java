package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.PromotionDetailDTO;
import com.Project.ChickenDeliveryBack.domain.repository.PromotionDetailRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.PromotionDetailCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.PromotionDetailMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PromotionDetailRepositoryImpl implements PromotionDetailRepository {

    private final PromotionDetailCrudRepository crudRepository;
    private final PromotionDetailMapper mapper;

    public PromotionDetailRepositoryImpl(PromotionDetailCrudRepository crudRepository, PromotionDetailMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public PromotionDetailDTO save(PromotionDetailDTO promotionDetailDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(promotionDetailDTO)));
    }

    @Override
    public Optional<PromotionDetailDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<PromotionDetailDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionDetailDTO> findByVentaId(Integer idVenta) {
        return crudRepository.findByVenta_Id(idVenta).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<PromotionDetailDTO> findByPromocionId(Integer idPromocion) {
        return crudRepository.findByPromocion_Id(idPromocion).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
