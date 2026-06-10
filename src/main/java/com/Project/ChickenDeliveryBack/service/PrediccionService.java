package com.Project.ChickenDeliveryBack.service;

import com.Project.ChickenDeliveryBack.dto.PrediccionRequest;
import com.Project.ChickenDeliveryBack.dto.PrediccionResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrediccionService {

    private final RestTemplate restTemplate = new RestTemplate();

    public PrediccionResponse predecir(PrediccionRequest request) {

        String url = "http://localhost:8000/predict";

        return restTemplate.postForObject(
                url,
                request,
                PrediccionResponse.class
        );
    }
}