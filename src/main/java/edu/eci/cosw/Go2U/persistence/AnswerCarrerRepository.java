/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.persistence;

import edu.eci.cosw.Go2U.model.test.AnswerCarrer;
import edu.eci.cosw.Go2U.model.test.idAnswerCarrer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author cbonilla
 */
@Service
public interface AnswerCarrerRepository extends JpaRepository<AnswerCarrer,idAnswerCarrer>{
    
}
