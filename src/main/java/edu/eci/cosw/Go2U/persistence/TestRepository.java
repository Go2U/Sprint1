/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.persistence;

import edu.eci.cosw.Go2U.model.test.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author henry
 */
@Service
public interface TestRepository extends JpaRepository<Test,Integer>{
 
    @Query("from Test t where t.idUniversity= ?1")
    Test findTest(String idUniversity);
    
}
