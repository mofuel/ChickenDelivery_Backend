package com.Project.ChickenDeliveryBack.controller;

import com.Project.ChickenDeliveryBack.domain.dto.ProductCategoryDTO;
import com.Project.ChickenDeliveryBack.domain.service.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryDTO>> getAll() {
        return ResponseEntity.ok(productCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategoryDTO> getById(@PathVariable Integer id) {
        return productCategoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<ProductCategoryDTO> getByNombre(@PathVariable String nombre) {
        return productCategoryService.findByNombre(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductCategoryDTO> create(@RequestBody ProductCategoryDTO dto) {
        ProductCategoryDTO saved = productCategoryService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productCategoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
