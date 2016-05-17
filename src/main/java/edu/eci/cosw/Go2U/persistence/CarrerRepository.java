/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.persistence;

import edu.eci.cosw.Go2U.model.universities.Carrer;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author HenryMonroy
 */
public interface CarrerRepository extends JpaRepository<Carrer,Integer>{
    @Query("select c from Carrer c")
    ArrayList<Carrer> getAllCarrers();
}
