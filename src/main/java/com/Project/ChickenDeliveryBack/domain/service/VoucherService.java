package com.Project.ChickenDeliveryBack.domain.service;

import com.Project.ChickenDeliveryBack.domain.dto.VoucherDTO;
import com.Project.ChickenDeliveryBack.domain.repository.VoucherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherService {

    private final VoucherRepository voucherRepository;

    public VoucherService(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    public VoucherDTO save(VoucherDTO dto) {
        if (dto.getTipoComprobante() == null || dto.getTipoComprobante().isBlank()) {
            throw new IllegalArgumentException("El tipo de comprobante es obligatorio");
        }
        if (dto.getNumeroComprobante() == null || dto.getNumeroComprobante().isBlank()) {
            throw new IllegalArgumentException("El número de comprobante es obligatorio");
        }
        if (dto.getTotal() == null || dto.getTotal().compareTo(java.math.BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El total debe ser mayor o igual a 0");
        }
        dto.setNumeroComprobante(dto.getNumeroComprobante().trim().toUpperCase());
        if (voucherRepository.findByNumeroComprobante(dto.getNumeroComprobante()).isPresent()) {
            throw new IllegalArgumentException("Ya existe un comprobante con ese número");
        }
        return voucherRepository.save(dto);
    }

    public Optional<VoucherDTO> findById(Integer id) {
        return voucherRepository.findById(id);
    }

    public List<VoucherDTO> findAll() {
        return voucherRepository.findAll();
    }

    public Optional<VoucherDTO> findByVentaId(Integer idVenta) {
        return voucherRepository.findByVentaId(idVenta);
    }

    public Optional<VoucherDTO> findByNumeroComprobante(String numeroComprobante) {
        return voucherRepository.findByNumeroComprobante(numeroComprobante);
    }

    public void deleteById(Integer id) {
        voucherRepository.deleteById(id);
    }
}
