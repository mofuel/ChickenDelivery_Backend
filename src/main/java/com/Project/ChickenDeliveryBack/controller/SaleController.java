package com.Project.ChickenDeliveryBack.controller;

import com.Project.ChickenDeliveryBack.domain.dto.SaleDTO;
import com.Project.ChickenDeliveryBack.domain.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable Integer id) {
        return saleService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<SaleDTO>> getByUsuarioId(@PathVariable Integer idUsuario) {
        return ResponseEntity.ok(saleService.findByUsuarioId(idUsuario));
    }

    @GetMapping("/cliente/{idCliente}")
    public ResponseEntity<List<SaleDTO>> getByClienteId(@PathVariable Integer idCliente) {
        return ResponseEntity.ok(saleService.findByClienteId(idCliente));
    }

    @GetMapping("/rango-fechas")
    public ResponseEntity<List<SaleDTO>> getByFechaVentaBetween(
            @RequestParam LocalDateTime start, @RequestParam LocalDateTime end) {
        return ResponseEntity.ok(saleService.findByFechaVentaBetween(start, end));
    }

    @PostMapping
    public ResponseEntity<SaleDTO> create(@RequestBody SaleDTO dto) {
        SaleDTO saved = saleService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        saleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
