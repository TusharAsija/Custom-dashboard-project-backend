package com.example.DummyGraphData.DummyGraphData.service;

import com.example.DummyGraphData.DummyGraphData.entity.*;
import com.example.DummyGraphData.DummyGraphData.repository.ChartDataRepository;
import com.example.DummyGraphData.DummyGraphData.repository.WidgetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChartDataService {

    @Autowired
    private ChartDataRepository chartDataRepository;

    @Autowired
    private WidgetRepository widgetRepository;

    public ChartData addMapEntity(ChartData mapEntity) {
        chartDataRepository.save(mapEntity);
        return mapEntity;
    }

    public List<ExampleChartData> getAllChartData() {
        List<ChartData> chartData = chartDataRepository.findAll();

        List<ExampleChartData> exampleChartData = new ArrayList<>();

        for(int i = 0; i < chartData.size(); i++) {
            ExampleChartData e = new ExampleChartData();
            BeanUtils.copyProperties(chartData.get(i),e);
            exampleChartData.add(e);
        }
        return exampleChartData;
//        return chartDataRepository.findAll();
    }

    public List<ExampleChartData> getChartDataByWidgetId(Long id) {
        List<ChartData> c = chartDataRepository.findByWidgetId(id);
        List<ExampleChartData> exampleChartData = new ArrayList<>();

        for(int i = 0; i < c.size(); i++) {
            ExampleChartData e = new ExampleChartData();
            BeanUtils.copyProperties(c.get(i),e);
            exampleChartData.add(e);
        }

//        ExampleChartData e = new ExampleChartData();
//        BeanUtils.copyProperties(c, e);
        return exampleChartData;
    }

    public ChartData addNewChartData(IncomingChartData incomingChartData) {
        ChartData newChartData = new ChartData();
        BeanUtils.copyProperties(incomingChartData, newChartData);
        newChartData.setWidget(widgetRepository.findById(incomingChartData.getWidgetId()).get());
        chartDataRepository.save(newChartData);
        return newChartData;
    }
}

