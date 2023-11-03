package com.example.DummyGraphData.DummyGraphData.service;

import com.example.DummyGraphData.DummyGraphData.entity.ChartData;
import com.example.DummyGraphData.DummyGraphData.entity.DashBoards;
import com.example.DummyGraphData.DummyGraphData.entity.Widgets;
import com.example.DummyGraphData.DummyGraphData.repository.ChartDataRepository;
import com.example.DummyGraphData.DummyGraphData.repository.DashboardRepository;
import com.example.DummyGraphData.DummyGraphData.repository.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    @Autowired
    private DashboardRepository dashboardRepository;
    @Autowired
    private WidgetRepository widgetRepository;
    @Autowired
    private ChartDataRepository chartDataRepository;

    public DashBoards addDashboard(DashBoards dashBoard) {
        dashboardRepository.save(dashBoard);
        return dashBoard;
    }

    public List<DashBoards> getAllDashboards() {
        return dashboardRepository.findAll();
    }

    public String deleteDashBoardById(Long id) {
        List<Widgets> widgets = widgetRepository.findByDashboardId(id);
        for(int i = 0; i < widgets.size(); i++){
            List<ChartData> chartDataForWidget = chartDataRepository.findByWidgetId(widgets.get(i).getWidgetId());
            for(int j = 0; j < chartDataForWidget.size(); j++){
                chartDataRepository.deleteById(chartDataForWidget.get(j).getMapEntityId());
            }
            widgetRepository.deleteById(widgets.get(i).getWidgetId());
        }
        dashboardRepository.deleteById(id);
        return "The DashBoard Is Deleted Successfully";
    }

    public DashBoards getDashBoardById(Long id) {
        return dashboardRepository.findById(id).get();
    }

    public DashBoards updateDashboard(Long id, DashBoards dashboard) {
        DashBoards dashBoards = dashboardRepository.findById(id).get();
        dashBoards.setDashboardName(dashboard.getDashboardName());
        dashBoards.setCreatedAt(dashboard.getCreatedAt());
        dashBoards.setCreatedBy(dashboard.getCreatedBy());
        dashboardRepository.save(dashBoards);
        return dashboard;
    }
}

