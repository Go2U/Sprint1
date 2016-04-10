/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.user;

import edu.eci.cosw.Go2U.model.user.User;

/**
 *
 * @author miguelromero
 */
public interface UserServiceInterface {
    public void addUser(User u);
    public User getUserByUsername(String username);
    public String getRolNameById(Integer id);
}
