package com.example.distancetimematrix.services;

import com.example.distancetimematrix.dtos.MatrixRequest;
import com.example.distancetimematrix.dtos.MatrixResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class MatrixService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${graphHopperApikey}")
    private String key;


    public MatrixResponse calculateMatrix(MatrixRequest matrixRequest) {
        String url = "https://graphhopper.com/api/1/matrix?key=" + key;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<MatrixRequest> requestEntity = new HttpEntity<>(matrixRequest, headers);

        ResponseEntity<MatrixResponse> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                MatrixResponse.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return null;
        }
    }
}
