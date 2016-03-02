/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.test;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author cbonilla
 */
@Service
public class ServiceTestUniversity implements ServiceTestUniversityInterface{
    
    Test test;
    
    public ServiceTestUniversity(){
        test = new Test();
    }
    
    @Override
    public int getIdUniversity() {
        return test.getIdUniversity();
    }

    @Override
    public ArrayList<Questions> getTest() {
        return test.getTest();
    }

    @Override
    public ArrayList<Questions> Test(int u) {
        return test.Test(u);
    }

    @Override
    public void addQuestions(Questions q) {
        test.addQuestions(q);
    }
}
