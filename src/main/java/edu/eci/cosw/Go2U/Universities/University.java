/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.Universities;

import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author miguelromero
 */
public class University {
    private String id;
    private String pass;
    private String name;
    private String city;
    private String email;
    private String url;
    private String address;
    private String descp;
    private Integer number;
    private ArrayList<Carrer> carrers;
    private InputStream logo;
    
    public University(String id, String pass){
        this.id = id;
        this.pass = pass; 
    }
    
    public University(){
        
    }

    /**
     * @return the name
     */
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
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the address
     */
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
    public ArrayList<Carrer> getCarrers() {
        return carrers;
    }
    
    public void addCarrer(Carrer c){
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
    
    public void addCarrers(ArrayList<Carrer> c){
        this.carrers = c;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the logo
     */
    public InputStream getLogo() {
        return logo;
    }

    /**
     * @param logo the logo to set
     */
    public void setLogo(InputStream logo) {
        this.logo = logo;
    }

    /**
     * @return the email
     */
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
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
