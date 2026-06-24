package com.Project.ChickenDeliveryBack.persistence.crud;

import com.Project.ChickenDeliveryBack.persistence.entity.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherCrudRepository extends JpaRepository<Voucher, Integer> {
    Optional<Voucher> findByVenta_Id(Integer idVenta);
    Optional<Voucher> findByNumeroComprobante(String numeroComprobante);
}