package com.Project.ChickenDeliveryBack.persistence.repositoryimpl;

import com.Project.ChickenDeliveryBack.domain.dto.VoucherDTO;
import com.Project.ChickenDeliveryBack.domain.repository.VoucherRepository;
import com.Project.ChickenDeliveryBack.persistence.crud.VoucherCrudRepository;
import com.Project.ChickenDeliveryBack.persistence.mapper.VoucherMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VoucherRepositoryImpl implements VoucherRepository {

    private final VoucherCrudRepository crudRepository;
    private final VoucherMapper mapper;

    public VoucherRepositoryImpl(VoucherCrudRepository crudRepository, VoucherMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public VoucherDTO save(VoucherDTO voucherDTO) {
        return mapper.toDto(crudRepository.save(mapper.toEntity(voucherDTO)));
    }

    @Override
    public Optional<VoucherDTO> findById(Integer id) {
        return crudRepository.findById(id).map(mapper::toDto);
    }

    @Override
    public List<VoucherDTO> findAll() {
        return crudRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<VoucherDTO> findByVentaId(Integer idVenta) {
        return crudRepository.findByVenta_Id(idVenta).map(mapper::toDto);
    }

    @Override
    public Optional<VoucherDTO> findByNumeroComprobante(String numeroComprobante) {
        return crudRepository.findByNumeroComprobante(numeroComprobante).map(mapper::toDto);
    }

    @Override
    public void deleteById(Integer id) {
        crudRepository.deleteById(id);
    }
}
