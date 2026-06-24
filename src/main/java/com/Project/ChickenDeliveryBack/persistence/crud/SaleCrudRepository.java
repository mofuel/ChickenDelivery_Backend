package com.Project.ChickenDeliveryBack.persistence.crud;

import com.Project.ChickenDeliveryBack.persistence.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SaleCrudRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findByUsuario_Id(Integer idUsuario);
    List<Sale> findByCliente_Id(Integer idCliente);
    List<Sale> findByFechaVentaBetween(LocalDateTime start, LocalDateTime end);
}