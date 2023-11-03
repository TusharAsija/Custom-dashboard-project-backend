package com.example.DummyGraphData.DummyGraphData.repository;

import com.example.DummyGraphData.DummyGraphData.entity.DashBoards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<DashBoards, Long> {
}
