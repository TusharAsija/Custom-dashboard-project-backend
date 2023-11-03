package com.example.DummyGraphData.DummyGraphData.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DummyDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private Long mathsMarks;
    private Long physicsMarks;
    private Long chemistryMarks;

    @ManyToOne
    @JoinColumn(
            name = "class_id",
            referencedColumnName = "classId"
    )
    private SchoolData schoolData;

}
