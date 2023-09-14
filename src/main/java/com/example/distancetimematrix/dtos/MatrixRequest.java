package com.example.distancetimematrix.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MatrixRequest {
    private List<String> out_arrays;
    private List<List<Double>> points;
    private String profile;
}
