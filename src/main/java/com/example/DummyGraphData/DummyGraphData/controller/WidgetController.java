package com.example.DummyGraphData.DummyGraphData.controller;

import com.example.DummyGraphData.DummyGraphData.entity.ChangeChartTypeModal;
import com.example.DummyGraphData.DummyGraphData.entity.ExampleWidget;
import com.example.DummyGraphData.DummyGraphData.entity.IncomingWidgetEntity;
import com.example.DummyGraphData.DummyGraphData.entity.Widgets;
import com.example.DummyGraphData.DummyGraphData.service.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class WidgetController {

    @Autowired
    private WidgetService widgetService;

    @PostMapping("/addWidget")
    public Widgets addWidget(@RequestBody Widgets widget) {
        return widgetService.addWidget(widget);
    }

    @GetMapping("/getAllWidgets")
    public List<ExampleWidget> getAllWidgets(){
        return widgetService.getAllWidgets();
    }

    @GetMapping("/widgetsByDashboardId/{id}")
    public List<ExampleWidget> getAllByDashboardId(@PathVariable Long id) {
        return widgetService.getAllByDashboardId(id);
    }

    @PostMapping("/addNewWidget")
    public Long addNewWidget(@RequestBody IncomingWidgetEntity incomingWidgetEntity) {
        return widgetService.addNewWidget(incomingWidgetEntity);
    }

    @DeleteMapping("/deleteWidget/{id}")
    public String deleteWidgetById(@PathVariable Long id){

        return widgetService.deleteWidgetById(id);
    }

    @PutMapping("/changeChartType")
    public ChangeChartTypeModal changeChartType(@RequestBody ChangeChartTypeModal changeChartTypeModal) {
        return widgetService.changeChartType(changeChartTypeModal);
    }
}
