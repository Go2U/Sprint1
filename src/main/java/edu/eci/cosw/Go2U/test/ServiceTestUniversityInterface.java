/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.test;

import java.util.ArrayList;

/**
 *
 * @author cbonilla
 */
public interface ServiceTestUniversityInterface {
    public int getIdUniversity();
    public ArrayList<Questions> getTest();
    public ArrayList<Questions> Test(int u);
    public void addQuestions(Questions q); 
}
