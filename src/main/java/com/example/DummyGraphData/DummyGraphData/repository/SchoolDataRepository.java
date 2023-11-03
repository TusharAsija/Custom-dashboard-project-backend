package com.example.DummyGraphData.DummyGraphData.repository;

import com.example.DummyGraphData.DummyGraphData.entity.SchoolData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDataRepository extends JpaRepository<SchoolData, Long> {
}
