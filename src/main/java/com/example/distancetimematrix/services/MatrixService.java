package com.example.distancetimematrix.services;

import com.example.distancetimematrix.dtos.MatrixRequest;
import com.example.distancetimematrix.dtos.MatrixResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
@Service
public class MatrixService {
    private final WebClient webClient;

    public MatrixService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://graphhopper.com/api/1/matrix?key=65486ad0-eab2-452b-9a0c-db8d938b9b44").build();
    }

    public MatrixResponse calculateMatrix(MatrixRequest matrixRequest) {
        return webClient
                .post()
//                .uri("/matrix")
                .body(BodyInserters.fromValue(matrixRequest))
                .retrieve()
                .bodyToMono(MatrixResponse.class)
                .block();
    }
}
