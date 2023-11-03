package com.example.DummyGraphData.DummyGraphData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Widgets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "dashboard_id",
            referencedColumnName = "dashboardId"
    )
    private DashBoards dashBoard;
}
