package com.example.DummyGraphData.DummyGraphData.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IncomingChartData {

    private String backgroundColor;
    private String borderColor;
    private Boolean borderSkipped;
    private Long borderWidth;
    private String label;
    private List<Integer> data;
    private Long widgetId;
}
