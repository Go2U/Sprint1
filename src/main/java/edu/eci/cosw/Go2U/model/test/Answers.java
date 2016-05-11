/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.test;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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

@Entity
@Table(name = "Answer")
@Proxy(lazy = false)
public class Answers implements java.io.Serializable{
    
    private Integer idAnswer=0;
    private String answer = "";
    private List<AnswerCarrer> academicProgramC = new ArrayList<>();
    
    public Answers(){
    }

    @Id
    @GeneratedValue
    @Column(name="idAnswer")
    public Integer getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Column(name="Answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @OneToMany
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="Answer_idAnswer_AC")//, insertable = false,updatable = false) 
    public List<AnswerCarrer> getAcademicProgramC() {
        return academicProgramC;
    }

    public void setAcademicProgramC(List<AnswerCarrer> academicProgramC) {
        this.academicProgramC = academicProgramC;
    }
    
}
