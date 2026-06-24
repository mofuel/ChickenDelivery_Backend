package com.Project.ChickenDeliveryBack.persistence.crud;

import com.Project.ChickenDeliveryBack.persistence.entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SaleDetailCrudRepository extends JpaRepository<SaleDetail, Integer> {
    List<SaleDetail> findByVenta_Id(Integer idVenta);
    List<SaleDetail> findByProducto_Id(Integer idProducto);
}
