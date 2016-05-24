/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.eci.cosw.Go2U.model.universities.University;
import edu.eci.cosw.Go2U.model.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
    private String email;
    private int cellPhone;
    //private List<Result> results =new ArrayList<>();
    
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

    /**
     * @return the email
     */
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}