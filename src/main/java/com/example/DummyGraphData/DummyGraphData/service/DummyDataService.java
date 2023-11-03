package com.example.DummyGraphData.DummyGraphData.service;

import com.example.DummyGraphData.DummyGraphData.entity.DummyDataEntity;
import com.example.DummyGraphData.DummyGraphData.entity.DummyDataModel;
import com.example.DummyGraphData.DummyGraphData.entity.Query;

import java.sql.SQLException;
import java.util.*;

public interface DummyDataService {
    DummyDataEntity addStudent(DummyDataModel student);

    List<DummyDataEntity> executeSQL();

    Object validateQuery(Query query) ;
}
