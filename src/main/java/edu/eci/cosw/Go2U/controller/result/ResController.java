/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.controller.result;

import edu.eci.cosw.Go2U.model.result.Result;
import edu.eci.cosw.Go2U.services.result.ServiceResult;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cris
 */

@RestController
@RequestMapping("/api/res")
public class ResController {
    
    @Autowired
    ServiceResult results;
    
    @RequestMapping(value = "/addRe",method = RequestMethod.POST)
    public void addResult(@RequestBody Result r) {
        results.addResult(r); 
    }
    
    @RequestMapping(method = RequestMethod.GET)    
    public List<Result> getResults() {        
        return results.getResults();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result getResultById(@PathVariable Integer id) {       
        return results.getResultById(id);   
    }
}
