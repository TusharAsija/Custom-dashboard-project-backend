package com.example.DummyGraphData.DummyGraphData.repository;

import com.example.DummyGraphData.DummyGraphData.entity.DummyDataEntity;
import com.example.DummyGraphData.DummyGraphData.service.DummyDataServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface DummyDataRepository extends JpaRepository<DummyDataEntity, Long> {

    @Query(value = "SELECT * from dummy_data_entity",
            nativeQuery = true)
    List<DummyDataEntity> getFromQuery();
}
