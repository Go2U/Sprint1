/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U;

import java.util.ArrayList;

/**
 *
 * @author miguelromero
 */
public interface ServiceInterface {
    public void addTask(Task t);    
    public ArrayList<Task> getTasks();
}
