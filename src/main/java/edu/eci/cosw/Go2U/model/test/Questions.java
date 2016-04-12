/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.test;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;
/**
 *
 * @author cbonilla
 */

//@Entity
//@Table(name = "Test")
//@Proxy(lazy = false)
public class Questions implements java.io.Serializable{
    
    private Integer idQuestion;
    private String question = "";
    private ArrayList<Answers> answer = new ArrayList<>();
    
    public Questions(){
    }

//    @Id
//    @Column(name="idQuestion")
    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

//    @Column(name="Question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

//    @OneToMany
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "Question_idQuestion", nullable = false)
    public ArrayList<Answers> getAnswer() {
        return answer;
    }

    public void setAnswer(ArrayList<Answers> answer) {
        this.answer = answer;
    }

}
