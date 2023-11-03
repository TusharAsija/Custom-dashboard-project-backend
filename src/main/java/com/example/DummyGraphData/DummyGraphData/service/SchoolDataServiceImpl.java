package com.example.DummyGraphData.DummyGraphData.service;

import com.example.DummyGraphData.DummyGraphData.entity.SchoolData;
import com.example.DummyGraphData.DummyGraphData.repository.SchoolDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolDataServiceImpl implements SchoolDataService{

    @Autowired
    private SchoolDataRepository schoolDataRepository;
    @Override
    public SchoolData addClass(SchoolData schoolData) {
        schoolDataRepository.save(schoolData);
        return schoolData;
    }
}
