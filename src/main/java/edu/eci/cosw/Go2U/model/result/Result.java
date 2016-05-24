    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.model.result;

import edu.eci.cosw.Go2U.model.universities.Carrer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author Cris
 */
@Entity
@Proxy(lazy = false)
@Table(name = "Result")
//@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Result implements java.io.Serializable{
    
    private Integer id;
    private String idStu;
    private Integer idTest;
    private List<Carrer> Carrers =new ArrayList<>();

    
    public Result(Integer id, Integer idTest, String idStu) {
        this.id = id;
        this.idTest = idTest;
        this.idStu = idStu;
        
    }
    
    public Result(){
    }

    /**
     * @return the Id
     */
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Column(name = "idResult")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
     * @return the Id Student
     */
    @Column(name = "Student_username")
    public String getIdStu() {
        return idStu;
    }

    public void setIdStu(String idStu) {
        this.idStu = idStu;
    }
    
    /**
     * @return the Id Test
     */
    @Column(name = "Test_idTest")
    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }
    
    /**
     * @return Carrers
     */
    @ManyToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinTable(name="Result_has_Carrer",joinColumns={@JoinColumn(name="Result_idResult", referencedColumnName="idResult", nullable = false)},
               inverseJoinColumns= {@JoinColumn(name="Carrer_idCarrer", referencedColumnName="idCarrer", nullable = false)}
              ) 
    public List<Carrer> getCarrers() {
        return Carrers;
    }

    public void setCarrers(List<Carrer> Carrers) {
        this.Carrers = Carrers;
    }
    
    
    
    
}
