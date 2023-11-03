package com.example.DummyGraphData.DummyGraphData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ChartData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mapEntityId;

    private String backgroundColor;
    private String borderColor;
    private Boolean borderSkipped;
    private Long borderWidth;
    private String label;
    private List<Integer> data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "widget_id",
            referencedColumnName = "widgetId"
    )
    private Widgets widget;

}
