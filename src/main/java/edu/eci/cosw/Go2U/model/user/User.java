/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author miguelromero
 */
@Entity
@Table(name = "User")
@Proxy(lazy = false)
public class User {
    private String username;
    private String password;
    private int role;
    private int salt;
    
    public User(){
        
    }

    /**
     * @return the username
     */
    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the ROLE
     */
    @Column(name = "role")
    public int getRole() {
        return role;
    }

    /**
     * @param role the ROLE to set
     */
    public void setRole(int Role) {
        this.role = Role;
    }

    /**
     * @return the salt
     */
    @Column(name = "salt")
    public int getSalt() {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public void setSalt(int salt) {
        this.salt = salt;
    }
    
    
}
