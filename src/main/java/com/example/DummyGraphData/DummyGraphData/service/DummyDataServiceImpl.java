package com.example.DummyGraphData.DummyGraphData.service;

import com.example.DummyGraphData.DummyGraphData.entity.DummyDataEntity;
import com.example.DummyGraphData.DummyGraphData.entity.DummyDataModel;
import com.example.DummyGraphData.DummyGraphData.entity.Query;
import com.example.DummyGraphData.DummyGraphData.entity.SchoolData;
import com.example.DummyGraphData.DummyGraphData.repository.DummyDataRepository;
import com.example.DummyGraphData.DummyGraphData.repository.SchoolDataRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.*;

@Service
public class DummyDataServiceImpl implements DummyDataService{

    public static String query;

    @Autowired
    private DummyDataRepository dummyDataRepository;

    @Autowired
    private SchoolDataRepository schoolDataRepository;

    @PersistenceContext
    private EntityManager entityManager;


    public static void setQuery(String query) {
        DummyDataServiceImpl.query = query;
    }

    @Override
    public DummyDataEntity addStudent(DummyDataModel student) {
        DummyDataEntity entity = new DummyDataEntity();
        BeanUtils.copyProperties(student, entity);
        SchoolData classData = schoolDataRepository.findById(student.getClassId()).get();
        entity.setSchoolData(classData);
        dummyDataRepository.save(entity);
        return entity;
    }

    @Override
    public List<DummyDataEntity> executeSQL() {


            return dummyDataRepository.getFromQuery();
    }

    @Override
    public Object validateQuery(Query query) {
        try {
            Statement stmt = CCJSqlParserUtil.parse(query.getQuery());

            if(stmt instanceof Select) {
                entityManager.createNativeQuery(query.getQuery()).getResultList();
                return "true";
//                return entityManager.createNativeQuery(query.getQuery()).getResultList();
//                return dummyDataRepository.getFromQuery();
            } else{
                String operation = stmt.getClass().getSimpleName();
//                return "Error: This is not a read-only query.";
                return "Operation '" + operation + "' is not allowed";
            }

        } catch (PersistenceException e){
            return "Error: " + e.getCause().getMessage();
        } catch (JSQLParserException e) {
            return "Error: Invalid SQL query syntax." + e.getMessage();
        }
    }


//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception e) {
//        return "Error: " + e.getMessage();
//    }
}
