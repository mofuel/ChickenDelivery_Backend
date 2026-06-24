package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDetailDTO;
import com.Project.ChickenDeliveryBack.domain.repository.SaleDetailRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.SaleDetailCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.SaleDetailMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SaleDetailRepositoryImpl implements SaleDetailRepository {

    private final SaleDetailCrudRepository crudRepository;
    private final SaleDetailMapper mapper;

    public SaleDetailRepositoryImpl(SaleDetailCrudRepository crudRepository, SaleDetailMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public SaleDetailDTO save(SaleDetailDTO saleDetailDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(saleDetailDTO)));
    }

    @Override
    public Optional<SaleDetailDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<SaleDetailDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SaleDetailDTO> findByVentaId(Integer idVenta) {
        return crudRepository.findByVenta_Id(idVenta).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SaleDetailDTO> findByProductoId(Integer idProducto) {
        return crudRepository.findByProducto_Id(idProducto).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
