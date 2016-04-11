/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.student;

import edu.eci.cosw.Go2U.model.user.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author Cris
 */
@Entity
@Table(name = "Student")
@Proxy(lazy = false)
public class Student implements java.io.Serializable{
    private String username;
    private String name;
    private String lastName;
    private String gender;
    private String address;
    private int cellPhone;
//    private Result result;

    public Student(String un, String name, String lastName) {
        super();
        this.username=un;
        this.name = name;
        this.lastName = lastName;
    }
    
    public Student(){
        super();
    }
    
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name = "cellPhone")
    public int getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(int cellPhone) {
        this.cellPhone = cellPhone;
    }    
    
//    @OneToOne()
//    @JoinColumn(name="Student_idStudent", referencedColumnName="idStudent", nullable = false)
//    public Result getResult() {
//        return result;
//    }
//
//    public void setResult(Result result) {
//        this.result = result;
//    }

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
}