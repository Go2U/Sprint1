/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.test;


import java.io.Serializable;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author cbonilla
 */
@Embeddable
public class idAnswerCarrer implements Serializable{
    
    private int idAnswer;// =0;
    private int idCarrer;// =1;

    @Column(name="Answer_idAnswer_AC")
    public int getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }
    private static final Logger LOG = Logger.getLogger(idAnswerCarrer.class.getName());

    @Column(name="Carrer_idCarrer")
    public int getIdCarrer() {
        return idCarrer;
    }

    public void setIdCarrer(int idCarrer) {
        this.idCarrer = idCarrer;
    }

    @Override
    public String toString() {
        return "idAnswerCarrer{" + "idAnswer=" + idAnswer + ", idCarrer=" + idCarrer + '}';
    }
    
    
    
}
