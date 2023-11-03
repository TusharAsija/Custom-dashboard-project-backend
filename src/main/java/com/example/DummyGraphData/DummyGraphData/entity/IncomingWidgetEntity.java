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
public class IncomingWidgetEntity {
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
    private Long dashBoardId;
}
