/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.test;

import edu.eci.cosw.Go2U.test.Answers;
import java.util.ArrayList;

/**
 *
 * @author cbonilla
 */
public class Questions {
    
    private String question = "";
    private ArrayList<Answers> answer = new ArrayList<>();
    
    public Questions(){
        question = "hola mundo";
        answer.add(new Answers());
        answer.add(new Answers());
        answer.add(new Answers());
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Answers> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<Answers> answer) {
        this.answer = answer;
    }

}