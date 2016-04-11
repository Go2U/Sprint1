/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.test;

import edu.eci.cosw.Go2U.model.test.Questions;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cbonilla
 */
public interface ServiceTestUniversityInterface {
//    public int getIdUniversity();
    public List<Questions> getTest();
//    public ArrayList<Questions> Test(int u);
    public void addQuestions(Questions q); 
}
