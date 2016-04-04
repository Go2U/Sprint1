/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.test;

import java.util.ArrayList;

/**
 *
 * @author cbonilla
 */
public class Test {
    private int idUniversity = 0;
    private ArrayList<Questions> test = new ArrayList<>();
    
    public Test(){
    }
    
    public int getIdUniversity() {
        return idUniversity;
    }

    public ArrayList<Questions> getTest() {
        return test;
    }

    public ArrayList<Questions> Test(int u) {
        if(idUniversity==u){
            return test;
        }
        return new ArrayList<>();
    }

    public void addQuestions(Questions q) {
        test.add(q);
    }
}
