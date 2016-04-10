/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.persistence;

import edu.eci.cosw.Go2U.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguelromero
 */
@Service
public interface UserRepository extends JpaRepository<User,String>{
    @Query("select r.name from Rol r where r.id= ?1")
    public String findRoleNameById(Integer id);
}
