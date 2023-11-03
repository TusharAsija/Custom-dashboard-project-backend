package com.example.DummyGraphData.DummyGraphData.service;

import com.example.DummyGraphData.DummyGraphData.entity.*;
import com.example.DummyGraphData.DummyGraphData.repository.ChartDataRepository;
import com.example.DummyGraphData.DummyGraphData.repository.DashboardRepository;
import com.example.DummyGraphData.DummyGraphData.repository.WidgetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class WidgetService {

    @Autowired
    private WidgetRepository widgetRepository;
    @Autowired
    private ChartDataRepository chartDataRepository;

    @Autowired
    private DashboardRepository dashboardRepository;
    public Widgets addWidget(Widgets widget) {
        widgetRepository.save(widget);
        return widget;
    }

    public List<ExampleWidget> getAllWidgets() {
        List<Widgets> widgets = widgetRepository.findAll();
//        System.out.println(widgets);
        List<ExampleWidget> exampleWidgets = new ArrayList<>();
        for(int i = 0; i < widgets.size(); i++) {
            ExampleWidget e = new ExampleWidget();
            BeanUtils.copyProperties(widgets.get(i),e);
            exampleWidgets.add(e);
//            e.setDashBoardId(1L);
        }
        return exampleWidgets;
    }

    public List<ExampleWidget> getAllByDashboardId(Long id) {
        List<Widgets> widgets = widgetRepository.findByDashboardId(id);

        List<ExampleWidget> exampleWidgets = new ArrayList<>();

        for(int i = 0; i < widgets.size(); i++) {
            ExampleWidget e = new ExampleWidget();
            BeanUtils.copyProperties(widgets.get(i),e);
            exampleWidgets.add(e);

        }
        return exampleWidgets;
    }

    public Long addNewWidget(IncomingWidgetEntity incomingWidgetEntity) {
        Widgets newWidget = new Widgets();
        BeanUtils.copyProperties(incomingWidgetEntity, newWidget);
        newWidget.setDashBoard(dashboardRepository.findById(incomingWidgetEntity.getDashBoardId()).get());
        widgetRepository.save(newWidget);
        return newWidget.getWidgetId();
    }

    public String deleteWidgetById(Long id) {
        List<ChartData> chartData = chartDataRepository.findByWidgetId(id);
        for(int i = 0; i < chartData.size(); i++) {
            chartDataRepository.deleteById(chartData.get(i).getMapEntityId());
        }
        widgetRepository.deleteById(id);
        return "Widget Deleted Successfully!";
    }

    public ChangeChartTypeModal changeChartType(ChangeChartTypeModal changeChartTypeModal) {
        Widgets widget = widgetRepository.findById(changeChartTypeModal.getId()).get();
        widget.setChartType(changeChartTypeModal.getChartType());
        widgetRepository.save(widget);
        return changeChartTypeModal;
    }
}

