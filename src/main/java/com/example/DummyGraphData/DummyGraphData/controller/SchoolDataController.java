package com.example.DummyGraphData.DummyGraphData.controller;

import com.example.DummyGraphData.DummyGraphData.entity.SchoolData;
import com.example.DummyGraphData.DummyGraphData.service.SchoolDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/school")
@CrossOrigin
public class SchoolDataController {

    @Autowired
    private SchoolDataService schoolDataService;
    @PostMapping("/addClass")
    public SchoolData addClass(@RequestBody SchoolData schoolData) {
        return schoolDataService.addClass(schoolData);
    }
}
