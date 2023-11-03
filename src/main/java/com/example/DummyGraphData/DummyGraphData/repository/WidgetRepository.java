package com.example.DummyGraphData.DummyGraphData.repository;

import com.example.DummyGraphData.DummyGraphData.entity.Widgets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface WidgetRepository extends JpaRepository<Widgets, Long> {


    @Query(
            value = "SELECT * FROM widgets WHERE dashboard_id = ?1",
            nativeQuery = true
    )
    List<Widgets> findByDashboardId(Long id);

}
