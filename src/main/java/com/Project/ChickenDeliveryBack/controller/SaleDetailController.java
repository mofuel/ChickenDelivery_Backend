package com.Project.ChickenDeliveryBack.controller;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDetailDTO;
import com.Project.ChickenDeliveryBack.domain.service.SaleDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-venta")
public class SaleDetailController {

    private final SaleDetailService saleDetailService;

    public SaleDetailController(SaleDetailService saleDetailService) {
        this.saleDetailService = saleDetailService;
    }

    @GetMapping
    public ResponseEntity<List<SaleDetailDTO>> getAll() {
        return ResponseEntity.ok(saleDetailService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDetailDTO> getById(@PathVariable Integer id) {
        return saleDetailService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<List<SaleDetailDTO>> getByVentaId(@PathVariable Integer idVenta) {
        return ResponseEntity.ok(saleDetailService.findByVentaId(idVenta));
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<List<SaleDetailDTO>> getByProductoId(@PathVariable Integer idProducto) {
        return ResponseEntity.ok(saleDetailService.findByProductoId(idProducto));
    }

    @PostMapping
    public ResponseEntity<SaleDetailDTO> create(@RequestBody SaleDetailDTO dto) {
        SaleDetailDTO saved = saleDetailService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        saleDetailService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
