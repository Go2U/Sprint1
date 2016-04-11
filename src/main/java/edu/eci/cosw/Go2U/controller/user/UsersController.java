/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.controller.user;

import edu.eci.cosw.Go2U.model.user.User;
import edu.eci.cosw.Go2U.services.universities.ServiceUniversity;
import edu.eci.cosw.Go2U.services.user.ServiceUser;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author miguelromero
 */
@RestController
@RequestMapping("/api")
public class UsersController {  
    
    @Autowired
    ServiceUser users;
    
    @RequestMapping(value = "/user")
    public Principal user(Principal user) {
        return user;
    }
    
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public void addUser(@RequestBody User u) {
        users.addUser(u);
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUniversityById(@PathVariable String username) {
        //System.out.println("entro");
        return users.getUserByUsername(username);
    }

}

