package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDTO;
import com.Project.ChickenDeliveryBack.domain.repository.SaleRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.SaleCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.SaleMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SaleRepositoryImpl implements SaleRepository {

    private final SaleCrudRepository crudRepository;
    private final SaleMapper mapper;

    public SaleRepositoryImpl(SaleCrudRepository crudRepository, SaleMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public SaleDTO save(SaleDTO saleDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(saleDTO)));
    }

    @Override
    public Optional<SaleDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<SaleDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SaleDTO> findByUsuarioId(Integer idUsuario) {
        return crudRepository.findByUsuario_Id(idUsuario).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SaleDTO> findByClienteId(Integer idCliente) {
        return crudRepository.findByCliente_Id(idCliente).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<SaleDTO> findByFechaVentaBetween(LocalDateTime start, LocalDateTime end) {
        return crudRepository.findByFechaVentaBetween(start, end).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
