/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.test;

import edu.eci.cosw.Go2U.model.test.Test;
import edu.eci.cosw.Go2U.model.test.Questions;
//import edu.eci.cosw.Go2U.persistence.TestRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cbonilla
 */
@Service
public class ServiceTestUniversity implements ServiceTestUniversityInterface{    
    Test prueba=new Test();
    
//    @Autowired
//    TestRepository test;
    
    public ServiceTestUniversity(){        
    }
    
//    @Override
//    public int getIdUniversity() {
//        return test.getIdUniversity();
//    }

    @Override
    public List<Questions> getTest() {
        return prueba.getQuestions();
    }

//    @Override
//    public ArrayList<Questions> Test(int u) {
//        return test.Test(u);
//    }

    @Override
    public void addQuestions(Questions q) {
        prueba.setQuestions(q);
    }
}
