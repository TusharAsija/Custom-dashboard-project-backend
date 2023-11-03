package com.example.DummyGraphData.DummyGraphData.controller;

import com.example.DummyGraphData.DummyGraphData.entity.DummyDataEntity;
import com.example.DummyGraphData.DummyGraphData.entity.DummyDataModel;
import com.example.DummyGraphData.DummyGraphData.entity.Query;
import com.example.DummyGraphData.DummyGraphData.service.DummyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class DummyDataController {

    @Autowired
    private DummyDataService dummyDataService;

    @PostMapping("/addStudent")
    public DummyDataEntity addStudent(@RequestBody DummyDataModel student) {
        return dummyDataService.addStudent(student);
    }

    @GetMapping("/executeSql")
    public List<DummyDataEntity> executeSql() throws SQLException {
        return dummyDataService.executeSQL();
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/execute-sql")
    public List<Map<String, Object>> executeSQL(@RequestBody Query query) {
        Object obj = validateQuery(query);

        if(String.valueOf(obj) == "true") {
            String sqlQuery = query.getQuery();
            List<Map<String, Object>> result = jdbcTemplate.queryForList(sqlQuery);
            return result;
        }

        Map<String, Object> map = new HashMap<>();
        map.put(String.valueOf(obj), false);

        return List.of(map);

    }

    public Object validateQuery(Query query) {
        return dummyDataService.validateQuery(query);
    }

}
