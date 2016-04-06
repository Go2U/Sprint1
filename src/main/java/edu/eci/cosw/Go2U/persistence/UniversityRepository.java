/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.persistence;

import edu.eci.cosw.Go2U.model.universities.University;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author HenryMonroy
 */
public interface UniversityRepository extends JpaRepository<University,String>{
    
}
