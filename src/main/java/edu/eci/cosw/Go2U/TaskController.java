/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author miguelromero
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    ServiceTask service;
    
    @RequestMapping(value = "/getTasks", method = RequestMethod.GET)
    public ArrayList<Task> getTasks(){
        return service.getTasks();
    }
    
    @RequestMapping(value = "/postTask",method = RequestMethod.POST)
    public void postTask(@RequestBody Task t) {
        service.addTask(t);
    }
}

//curl -H "Content-Type: application/json" -X POST -d '{"desc":"hola","prio":1}' http://localhost:8080/Task/postTask
//curl -H "Content-Type: application/json" -X GET http://localhost:8080/Task/getTasks