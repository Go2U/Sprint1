/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.persistence;

import edu.eci.cosw.Go2U.model.universities.University;
//import java.sql.Blob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author HenryMonroy
 */
@Service
public interface UniversityRepository extends JpaRepository<University,String>{
    @Query("select u.logo from University u where u.id= ?1")
    java.sql.Blob findLogoById(String id);
    
}
