package com.example.distancetimematrix.controllers;

import com.example.distancetimematrix.dtos.MatrixRequest;
import com.example.distancetimematrix.dtos.MatrixResponse;
import com.example.distancetimematrix.services.MatrixService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatrixController {

    @Autowired
    private MatrixService matrixService;

    @PostMapping("/calculate")
    public ResponseEntity<MatrixResponse> calculateAndStoreMatrix(@RequestBody MatrixRequest matrixRequest) {
        MatrixResponse matrixResponse = matrixService.calculateMatrix(matrixRequest);

        List<List<Integer>> distances = matrixResponse.getDistances();
        List<List<Integer>> times = matrixResponse.getTimes();


        if (matrixResponse != null) {
            return new ResponseEntity<>(matrixResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
