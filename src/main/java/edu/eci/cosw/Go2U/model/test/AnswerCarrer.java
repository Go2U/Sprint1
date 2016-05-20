/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.test;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author cbonilla
 */
@Entity
@Table(name = "Answer_has_Carrer")
@Proxy(lazy = false)
public class AnswerCarrer implements Serializable{
    
    int valSum=0;
    idAnswerCarrer id = new idAnswerCarrer();

   public AnswerCarrer() {
    }

    @EmbeddedId
    public idAnswerCarrer getId() {
        return id;
    }

    public void setId(idAnswerCarrer id) {
        this.id = id;
    }

    @Column(name="valor")
    public Integer getValSum() {
        return valSum;
    }

    public void setValSum(Integer valSum) {
        this.valSum = valSum;
    }

    @Override
    public String toString() {
        return "AnswerCarrer{" + "valSum=" + valSum + ", id=" + id.toString() + '}';
    }
    
    
}
