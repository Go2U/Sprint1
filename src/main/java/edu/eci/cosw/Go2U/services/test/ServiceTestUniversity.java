/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.test;

import edu.eci.cosw.Go2U.model.test.Test;
import edu.eci.cosw.Go2U.model.test.Questions;
import edu.eci.cosw.Go2U.persistence.TestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cbonilla
 */
@Service
public class ServiceTestUniversity implements ServiceTestUniversityInterface{    

    @Autowired
    TestRepository test;
    
    public ServiceTestUniversity(){
    }

    @Override
    public void setIdUniversity(String university) {        
    }
    
    @Override
    public List<Questions> getTest(String university) {
        Test prueba1 = test.findTest(university);
        if(prueba1==null){
            prueba1 = new Test();
            prueba1.setIdUniversity(university);
        }
        return prueba1.getQuestions();
    }

    @Override
    public void addQuestions(String u, Questions q) {
        Test t = test.findTest(u);
        t.setQuestion(q);
        test.save(t);
    }
}
