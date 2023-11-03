package com.example.DummyGraphData.DummyGraphData.repository;

import com.example.DummyGraphData.DummyGraphData.entity.ChartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ChartDataRepository extends JpaRepository<ChartData, Long> {
    @Query(
            value = "SELECT * FROM chart_data WHERE widget_id = ?1",
            nativeQuery = true
    )
    List<ChartData> findByWidgetId(Long id);
}