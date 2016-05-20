/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.controller.test;

import edu.eci.cosw.Go2U.services.test.ServiceTestUniversity;
import edu.eci.cosw.Go2U.model.test.Questions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
 
    @RequestMapping(value = "/getTestUniversity/{id}", method = RequestMethod.GET)
    public List<Questions> getTestUniversity(@PathVariable String id){
        TestUniversity.setIdUniversity(id);
        List<Questions> p = TestUniversity.getTest(id);
        return p;
    }
    
    @RequestMapping(value = "/getQuestion/{id}", method = RequestMethod.GET)
    public Questions getQuestion(@PathVariable String id){
        return TestUniversity.getQuestion(id);
    }
    
    @RequestMapping(value = "/postQuestions/{id}",method = RequestMethod.POST)
    public void postTask(@PathVariable String id,@RequestBody Questions q) {
        TestUniversity.addQuestions(id,q);
    }
    
    @RequestMapping(value = "/postQuestionsMod/{id}",method = RequestMethod.POST)
    public void postTaskMod(@PathVariable String id,@RequestBody Questions q) {
        TestUniversity.modQuestions(id,q);
    }
    
    
}
