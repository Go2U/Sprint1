/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.universities;

import edu.eci.cosw.Go2U.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mysql.jdbc.Blob;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author miguelromero
 */
@Entity
@Table(name = "University")
@Proxy(lazy = false)
public class University implements java.io.Serializable {
    private String username;
    private String name;
    private Integer city;
    private String email;
    private String url;
    private String address;
    private String descp;
    private Integer number;
    private List<Carrer> carrers;
    private Blob Logo;
    
    public University(String un, List<Carrer> carrers){
        this.username=un;
        this.carrers = carrers;
    }
    
    public University(){
        super();
    }
    
    // ***Constructor para realizar pruebas*** //
    public University(String un, String name, String email){
        this.city=0;
        this.username=un;
        this.name=name;
        this.email=email;
    }
    
    /**
     * @return the name
     */
    @Column(name="name")
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the city
     */
    @Column(name="City_idCity", nullable = true)
    public Integer getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(int city) {
        this.city = city;
    }

    /**
     * @return the address
     */
     @Column(name="address")
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the number
     */
     @Column(name="number")
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return the carrers
     */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "universities")
    @Fetch(FetchMode.JOIN)
    //@JoinColumn(name = "University_username", referencedColumnName = "username", nullable = false)
    public List<Carrer> getCarrers() {
        return carrers;
    }
    
    public void setCarrer(Carrer c){
        boolean exits=false;
        for (Carrer ca:this.getCarrers()){
            if (ca.getName().compareTo(c.getName())==0){
                exits=true;
            }
        }
        if (!exits) {
            this.getCarrers().add(c);
        }
    }
    
    public void setCarrers(List<Carrer> c){
//        this.carrers = new Set<>();
        this.carrers = c;
    }

    /**
     * @return the logo
     */
    @Column(name="Logo")
    @JsonIgnore
    public java.sql.Blob getLogo() {
        return Logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(Blob logo) {
        this.Logo = logo;
    }

    /**
     * @return the email
     */
     @Column(name="email")
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the url
     */
     @Column(name="url")
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the descp
     */
     @Column(name="descp")
    public String getDescp() {
        return descp;
    }

    /**
     * @param descp the descp to set
     */
    public void setDescp(String descp) {
        this.descp = descp;
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
     * @return the pass
     */
    
}
