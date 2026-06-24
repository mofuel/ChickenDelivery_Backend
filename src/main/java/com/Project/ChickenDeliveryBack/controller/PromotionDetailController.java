package com.Project.ChickenDeliveryBack.controller;

import com.Project.ChickenDeliveryBack.domain.dto.PromotionDetailDTO;
import com.Project.ChickenDeliveryBack.domain.service.PromotionDetailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-promocion")
public class PromotionDetailController {

    private final PromotionDetailService promotionDetailService;

    public PromotionDetailController(PromotionDetailService promotionDetailService) {
        this.promotionDetailService = promotionDetailService;
    }

    @GetMapping
    public ResponseEntity<List<PromotionDetailDTO>> getAll() {
        return ResponseEntity.ok(promotionDetailService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PromotionDetailDTO> getById(@PathVariable Integer id) {
        return promotionDetailService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/venta/{idVenta}")
    public ResponseEntity<List<PromotionDetailDTO>> getByVentaId(@PathVariable Integer idVenta) {
        return ResponseEntity.ok(promotionDetailService.findByVentaId(idVenta));
    }

    @GetMapping("/promocion/{idPromocion}")
    public ResponseEntity<List<PromotionDetailDTO>> getByPromocionId(@PathVariable Integer idPromocion) {
        return ResponseEntity.ok(promotionDetailService.findByPromocionId(idPromocion));
    }

    @PostMapping
    public ResponseEntity<PromotionDetailDTO> create(@RequestBody PromotionDetailDTO dto) {
        PromotionDetailDTO saved = promotionDetailService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        promotionDetailService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
