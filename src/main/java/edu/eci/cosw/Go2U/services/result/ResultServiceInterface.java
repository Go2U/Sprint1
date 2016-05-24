/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.result;

import edu.eci.cosw.Go2U.model.result.Result;
import java.util.List;

/**
 *
 * @author Cris
 */
public interface ResultServiceInterface {
        
    public void addResult(Result r);
    public List<Result> getResults();
    public Result getResultById(Integer id);
    public List<Result> getStudentResults(String id);
    
}
