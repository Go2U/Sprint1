/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.test;

import edu.eci.cosw.Go2U.model.universities.Carrer;
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
public class Answers implements java.io.Serializable{
    
    private Integer idAnswer=0;
    private String answer = "";
    private ArrayList<AnswerCarrer> academicProgramC = new ArrayList<>();
    
    public Answers(){
    }

//    @Id
//    @Column(name="idAnswer")
    public Integer getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

//    @Column(name="Answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

//    @OneToMany
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "Answer_idAnswer", nullable = false)
    public ArrayList<AnswerCarrer> getAcademicProgramC() {
        return academicProgramC;
    }

    public void setAcademicProgramC(ArrayList<AnswerCarrer> academicProgramC) {
        this.academicProgramC = academicProgramC;
    }
    
}
