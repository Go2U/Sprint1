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
public class Test implements java.io.Serializable{
    
    private Integer idTest;
    private String idUniversity = "";
    private List<Questions> questions = new ArrayList<>();
    
    public Test(){
        super();
    }
    
    public Test(String idUniversity){
        super();
        this.idUniversity = idUniversity;
    }
    
//    @Id
//    @Column(name="idTest")
    public Integer getIdTest() {
        return idTest;
    }


    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }
    
//    @Column(name="University_idUniversity", nullable = false)
    public String getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(String idUniversity) {
        this.idUniversity = idUniversity;
    }

//    @OneToMany
//    @Fetch(FetchMode.JOIN)
//    @JoinColumn(name = "Test_idTest", nullable = false)
    public List<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(Questions q) {
        questions.add(q);
    }
}
