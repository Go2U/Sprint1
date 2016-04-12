/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.test;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author cbonilla
 */
@Embeddable
public class idAnswerCarrer implements Serializable{
    
    private Integer idAnswer =0;
    private Integer idCarrer =0;

    @Column(name="Answer_idAnswer_AC",insertable = false,updatable = false)
    public Integer getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Integer idAnswer) {
        this.idAnswer = idAnswer;
    }

    @Column(name="Carrer_idCarrer")
    public Integer getIdCarrer() {
        return idCarrer;
    }

    public void setIdCarrer(Integer idCarrer) {
        this.idCarrer = idCarrer;
    }
    
}
