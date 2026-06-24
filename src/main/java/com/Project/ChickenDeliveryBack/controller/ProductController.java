package com.Project.ChickenDeliveryBack.controller;

import com.Project.ChickenDeliveryBack.domain.dto.ProductDTO;
import com.Project.ChickenDeliveryBack.domain.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getById(@PathVariable Integer id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<ProductDTO>> getByCategoriaId(@PathVariable Integer idCategoria) {
        return ResponseEntity.ok(productService.findByCategoriaId(idCategoria));
    }

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<ProductDTO>> getByNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(productService.findByNombreContainingIgnoreCase(nombre));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<ProductDTO>> getByEstado(@PathVariable Boolean estado) {
        return ResponseEntity.ok(productService.findByEstado(estado));
    }

    @PostMapping
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO dto) {
        ProductDTO saved = productService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
