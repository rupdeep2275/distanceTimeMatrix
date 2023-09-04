package com.example.distancetimematrix.controllers;

import com.example.distancetimematrix.dtos.MatrixRequest;
import com.example.distancetimematrix.dtos.MatrixResponse;
import com.example.distancetimematrix.services.MatrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatrixController {
    private final MatrixService matrixService;

    @Autowired
    public MatrixController(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<MatrixResponse> calculateAndStoreMatrix(@RequestBody MatrixRequest matrixRequest) {
        MatrixResponse matrixResponse = matrixService.calculateMatrix(matrixRequest);

        List<List<Integer>> distances = matrixResponse.getDistances();
        List<List<Integer>> times = matrixResponse.getTimes();

//        System.out.println("Distances:");
//        for (List<Integer> distanceRow : distances) {
//            System.out.println(distanceRow);
//        }
//        System.out.println("Times:");
//        for (List<Integer> timeRow : times) {
//            System.out.println(timeRow);
//        }

        if (matrixResponse != null) {
            return new ResponseEntity<>(matrixResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

//        return ResponseEntity.ok("Matrix calculated and data stored.");
    }
}
