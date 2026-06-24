package com.Project.ChickenDeliveryBack.domain.repository;

import com.Project.ChickenDeliveryBack.domain.dto.VoucherDTO;

import java.util.List;
import java.util.Optional;

public interface VoucherRepository {
    VoucherDTO save(VoucherDTO voucherDTO);
    Optional<VoucherDTO> findById(Integer id);
    List<VoucherDTO> findAll();
    Optional<VoucherDTO> findByVentaId(Integer idVenta);
    Optional<VoucherDTO> findByNumeroComprobante(String numeroComprobante);
    void deleteById(Integer id);
}
