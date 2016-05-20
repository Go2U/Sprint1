/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.persistence;

import edu.eci.cosw.Go2U.model.test.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author cbonilla
 */

@Service
public interface QuestionRepository extends JpaRepository<Questions,Integer>{
    
    @Query("from Questions q where q.idQuestion= ?1")
    Questions findQuestion(int idQuestion);
    
}