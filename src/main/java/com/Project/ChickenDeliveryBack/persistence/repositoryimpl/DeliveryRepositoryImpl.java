package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.DeliveryDTO;
import com.Project.ChickenDeliveryBack.domain.repository.DeliveryRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.DeliveryCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.DeliveryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DeliveryRepositoryImpl implements DeliveryRepository {

    private final DeliveryCrudRepository crudRepository;
    private final DeliveryMapper mapper;

    public DeliveryRepositoryImpl(DeliveryCrudRepository crudRepository, DeliveryMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public DeliveryDTO save(DeliveryDTO deliveryDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(deliveryDTO)));
    }

    @Override
    public Optional<DeliveryDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<DeliveryDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<DeliveryDTO> findByVentaId(Integer idVenta) {
        return crudRepository.findByVenta_Id(idVenta).map(mapper::toDto);
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
