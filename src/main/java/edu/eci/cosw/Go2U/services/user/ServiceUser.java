/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.user;

import edu.eci.cosw.Go2U.model.user.User;
import edu.eci.cosw.Go2U.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguelromero
 */
@Service
public class ServiceUser implements UserServiceInterface{
    
    @Autowired
    UserRepository user;
    
    
    @Override
    public void addUser(User u) {
        user.save(u);
    }

    @Override
    public User getUserByUsername(String username) {
        return user.findOne(username);
    }
    
    @Override
    public String getRolNameById(Integer id){
        return user.findRoleNameById(id);
    }
}
