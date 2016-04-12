/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.controller.test;

import edu.eci.cosw.Go2U.services.test.ServiceTestUniversity;
import edu.eci.cosw.Go2U.model.test.Questions;
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
    
    @RequestMapping(value = "/getTestUniversity", method = RequestMethod.GET)
    public List<Questions> getTestUniversity(){
        return TestUniversity.getTest();
    }
    
    @RequestMapping(value = "/getTestUniversity/{id}", method = RequestMethod.GET)
    public List<Questions> getTestUniversity(@PathVariable String id){
        TestUniversity.setIdUniversity(id);
        List<Questions> p = TestUniversity.getTest(id);
        return p;
    }
    
    @RequestMapping(value = "/postQuestions",method = RequestMethod.POST)
    public void postTask(@RequestBody Questions q) {
        System.out.println(q.getAnswer().size());
        System.out.println(q.getAnswer().get(0).getIdAnswer());
        TestUniversity.addQuestions(q);
    }
    
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public void save() {
        System.out.println("entra base");
        TestUniversity.Save();
    }
    
}
