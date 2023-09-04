package com.example.distancetimematrix.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class MatrixResponse {
    private List<List<Integer>> distances;
    private List<List<Integer>> times;
}
