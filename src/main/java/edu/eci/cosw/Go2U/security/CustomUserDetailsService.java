/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.security;

import edu.eci.cosw.Go2U.model.user.User;
import edu.eci.cosw.Go2U.services.user.Assembler;
import edu.eci.cosw.Go2U.services.user.ServiceUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author miguelromero
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    ServiceUser serviceUser;
    
    @Autowired
    private Assembler assembler;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = serviceUser.getUserByUsername(username);
        
        System.out.println("--------------->" + user.getUsername() + " " + user.getPassword());
        if (user == null) {
            //System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
//                true, true, true, true, getGrantedAuthorities(user));
        return assembler.buildUserFromUserEntity(user);
    }
    
    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + serviceUser.getRolNameById(user.getRole())));
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
