/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;

import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "Question")
@Proxy(lazy = false)
public class Questions implements java.io.Serializable{
    
    private int idQuestion;
    private String question = "";
    private List<Answers> answer = new ArrayList<>();
    
    public Questions(){
    }

    @Id
    @GeneratedValue
    @Column(name="idQuestion")
    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    @Column(name="Question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="Question_idQuestion", nullable = false)
    public List<Answers> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answers> answer) {
        this.answer = answer;
    }

    public Questions cloneQ(){
        Questions Q = new Questions();
        Q.setIdQuestion(this.getIdQuestion());
        for(Answers an:this.getAnswer()){
            Answers a =new Answers();
            a.setIdAnswer(an.getIdAnswer());
            a.setAnswer(an.getAnswer().toString());
            for(AnswerCarrer ac:an.getAcademicProgramC()){
                AnswerCarrer ansC = new AnswerCarrer();
                idAnswerCarrer id =new idAnswerCarrer();
                id.setIdAnswer(ac.getId().getIdAnswer());
                id.setIdCarrer(ac.getId().getIdCarrer());
                ansC.setId(id);
                ansC.setValSum(ac.getValSum());
                a.getAcademicProgramC().add(ansC);
            }
            Q.getAnswer().add(a);
        }
        return Q;
    }

    @Override
    public String toString() {
        return "Questions{" + "idQuestion=" + idQuestion + ", question=" + question + ", answer=" + answer.toString() + '}';
    }
    
}
