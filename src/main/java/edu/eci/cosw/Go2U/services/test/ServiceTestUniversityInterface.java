/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.test;

import edu.eci.cosw.Go2U.model.test.Questions;
import java.util.List;

/**
 *
 * @author cbonilla
 */
public interface ServiceTestUniversityInterface {
    public void setIdUniversity(String university);
    public List<Questions> getTest(String university);
    public Questions getQuestion(String idQuestion);
    public void addQuestions(String u, Questions q);
    public void modQuestions(String u, Questions q);
}
