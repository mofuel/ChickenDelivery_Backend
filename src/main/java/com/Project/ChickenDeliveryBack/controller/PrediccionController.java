package com.Project.ChickenDeliveryBack.controller;

import com.Project.ChickenDeliveryBack.dto.PrediccionRequest;
import com.Project.ChickenDeliveryBack.dto.PrediccionResponse;
import com.Project.ChickenDeliveryBack.service.PrediccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prediccion")
@CrossOrigin(origins = "*")
public class PrediccionController {

    private final PrediccionService prediccionService;

    public PrediccionController(PrediccionService prediccionService) {
        this.prediccionService = prediccionService;
    }

    @PostMapping
    public ResponseEntity<PrediccionResponse> predecir(
            @RequestBody PrediccionRequest request) {

        return ResponseEntity.ok(
                prediccionService.predecir(request)
        );
    }
}