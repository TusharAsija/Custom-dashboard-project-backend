package com.example.DummyGraphData.DummyGraphData.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExampleChartData {
    private String backgroundColor;
    private String borderColor;
    private Boolean borderSkipped;
    private Long borderWidth;
    private String label;
    private List<Integer> data;
}
