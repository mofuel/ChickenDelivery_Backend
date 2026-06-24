package com.Project.ChickenDeliveryBack.controller;

import com.Project.ChickenDeliveryBack.domain.dto.DeliveryDTO;
import com.Project.ChickenDeliveryBack.domain.service.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public ResponseEntity<List<DeliveryDTO>> getAll() {
        return ResponseEntity.ok(deliveryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryDTO> getById(@PathVariable Integer id) {
        return deliveryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<DeliveryDTO> getByVentaId(@PathVariable Integer idVenta) {
        return deliveryService.findByVentaId(idVenta)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DeliveryDTO> create(@RequestBody DeliveryDTO dto) {
        DeliveryDTO saved = deliveryService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        deliveryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
