 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguelromero
 */
@Service
public class ServiceTask implements ServiceInterface{
    public static ArrayList<Task> Tasks = new ArrayList<>();
    
    @Override
    public void addTask(Task t){
        Tasks.add(t);
    }
    
    @Override
    public ArrayList<Task> getTasks(){
        return Tasks;
    }
}
