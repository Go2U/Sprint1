/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.universities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author miguelromero
 */
@Entity
@Table(name = "Carrer")
@Proxy(lazy = false)
public class Carrer implements java.io.Serializable {

    private Integer id;
    private String name;
    private List<University> universities;

    public Carrer(String name, String dep) {
        this.name = name;
    }

    public Carrer(Integer id, String name, String dep) {
        this.id = id;
        this.name = name;
    }

    public Carrer() {

    }

    /**
     * @return the name
     */
    @Column(name = "name")
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
     * @return the id
     */
    @Id
    @Column(name = "idCarrer")
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name="Carrer_has_University",joinColumns={@JoinColumn(name="Carrer_idCarrer", referencedColumnName="idCarrer", nullable = false)},
               inverseJoinColumns= {@JoinColumn(name="University_username", referencedColumnName="username", nullable = false)}
              ) 
    public List<University> getUniversities() {
        return universities;
    }

    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }
}
