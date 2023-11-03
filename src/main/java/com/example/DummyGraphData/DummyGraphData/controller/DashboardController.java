package com.example.DummyGraphData.DummyGraphData.controller;


import com.example.DummyGraphData.DummyGraphData.entity.DashBoards;
import com.example.DummyGraphData.DummyGraphData.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;


    @PostMapping("/addDashboard")
    public DashBoards addDashboard(@RequestBody DashBoards dashBoard) {
        return dashboardService.addDashboard(dashBoard);
    }

    @GetMapping("/allDashboards")
    public List<DashBoards> getAllDashboards() {
        return dashboardService.getAllDashboards();
    }

    @DeleteMapping("/deleteDashBoard/{id}")
    public String deleteDashBoardById(@PathVariable Long id) {
        return dashboardService.deleteDashBoardById(id);
    }

    @GetMapping("/getDashBoard/{id}")
    public DashBoards getDashBoardById(@PathVariable Long id) {
        return dashboardService.getDashBoardById(id);
    }

    @PutMapping("/updateDashBoardData/{id}")
    public ResponseEntity<DashBoards> updateDashboard(@PathVariable Long id, @RequestBody DashBoards dashboard) {
        dashboard = dashboardService.updateDashboard(id, dashboard);
        return ResponseEntity.ok(dashboard);
    }

}