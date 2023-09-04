package com.example.distancetimematrix.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MatrixRequest {
    private boolean elevation;
    private List<String> out_arrays;
    private List<List<Double>> from_points;
    private List<List<Double>> to_points;
    private String profile;
}
