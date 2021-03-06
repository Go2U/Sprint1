/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.result;

import edu.eci.cosw.Go2U.model.result.Result;
import edu.eci.cosw.Go2U.model.universities.Carrer;
import edu.eci.cosw.Go2U.persistence.CarrerRepository;
import edu.eci.cosw.Go2U.persistence.ResultRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cris
 */
@Service
public class ServiceResult implements ResultServiceInterface {
    
    @Autowired
    ResultRepository result;
    @Autowired
    CarrerRepository carrer;

    @Override
    public void addResult(Result r) {
        result.save(r);
    }

    @Override
    public List<Result> getResults() {
        return result.findAll();
    }

    @Override
    public Result getResultById(Integer id) {
        return result.getOne(id);
    }

    @Override
    public List<Result> getStudentResults(String id) {
        List<Result> results = result.getAllResults();
        List<Result> studentResults = new ArrayList<Result>();
        for (Result r : results) {
            if(r.getIdStu().compareTo(id)==0){
                studentResults.add(r);
            }
        }
        return studentResults;
    }
}
