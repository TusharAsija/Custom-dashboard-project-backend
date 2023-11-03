package com.example.DummyGraphData.DummyGraphData.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExampleWidget {
    private Long widgetId;
    private String widgetName;
    private String query;
    private String typeOfWidget;
    private String chartType;
    private Long col;
    private Long colSpan;
    private Long rowSpan;
    private List<String> labels;
    private List<String> columns;
    private Long value;
//    private Long dashBoardId;
}
