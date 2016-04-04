/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.controller.test;

import edu.eci.cosw.Go2U.services.test.ServiceTestUniversity;
import edu.eci.cosw.Go2U.model.test.Questions;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cbonilla
 */
@RestController
@RequestMapping("/test")
public class TestUniversityController{

    @Autowired
    ServiceTestUniversity TestUniversity;
    
    @RequestMapping(value = "/getIdUniversity", method = RequestMethod.GET)
    public int getIdUniversity(){
        return TestUniversity.getIdUniversity();
    }
    
    @RequestMapping(value = "/getTestUniversity", method = RequestMethod.GET)
    public ArrayList<Questions> getTestUniversity(){
        return TestUniversity.getTest();
    }
    
    @RequestMapping(value = "/postQuestions",method = RequestMethod.POST)
    public void postTask(@RequestBody Questions q) {
        TestUniversity.addQuestions(q);
    }
    
}
