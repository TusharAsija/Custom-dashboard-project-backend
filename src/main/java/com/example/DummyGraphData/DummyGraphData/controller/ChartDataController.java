package com.example.DummyGraphData.DummyGraphData.controller;

import com.example.DummyGraphData.DummyGraphData.entity.ChartData;
import com.example.DummyGraphData.DummyGraphData.entity.ExampleChartData;
import com.example.DummyGraphData.DummyGraphData.entity.IncomingChartData;
import com.example.DummyGraphData.DummyGraphData.service.ChartDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class ChartDataController {

    @Autowired
    private ChartDataService chartDataService;

    @PostMapping("/addChartData")
    public ChartData addMapEntity(@RequestBody ChartData mapEntity) {
        return chartDataService.addMapEntity(mapEntity);
    }

    @GetMapping("/getAllChartData")
    public List<ExampleChartData> getAllChartData() {
        return chartDataService.getAllChartData();
    }

    @GetMapping("/getChartDataByWidgetId/{id}")
    public List<ExampleChartData> getChartDataByWidgetId(@PathVariable Long id) {
        return chartDataService.getChartDataByWidgetId(id);
    }

    @PostMapping("/addNewChartData")
    public ChartData addNewChartData(@RequestBody IncomingChartData incomingChartData) {
        return chartDataService.addNewChartData(incomingChartData);
    }
}
