package com.example.DummyGraphData.DummyGraphData.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DummyDataModel {
    private String studentName;
    private Long mathsMarks;
    private Long physicsMarks;
    private Long chemistryMarks;
    private Long classId;
}
