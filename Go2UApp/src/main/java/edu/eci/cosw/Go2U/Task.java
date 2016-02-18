/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U;

/**
 *
 * @author miguelromero
 */
public class Task {
    private String desc;
    private String prio;
    
    public Task(String desc, String prio){
        this.desc=desc;
        this.prio=prio;
    }
    
    public Task(){
        
    }
    
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    public String getPrio() {
        return prio;
    }

    public void setPrio(String prio) {
        this.prio = prio;
    }
    
}
