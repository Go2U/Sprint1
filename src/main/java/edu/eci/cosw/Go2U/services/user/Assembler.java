/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.Go2U.services.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author miguelromero
 */
@Service("assembler")
public class Assembler {

    @Autowired
    ServiceUser serviceUser;

    @Transactional(readOnly = true)
    public User buildUserFromUserEntity(edu.eci.cosw.Go2U.model.user.User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Collection authorities = getGrantedAuthorities(user);
        User User = new User(username, password, enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        return User;
    }

    private List<GrantedAuthority> getGrantedAuthorities(edu.eci.cosw.Go2U.model.user.User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + serviceUser.getRolNameById(user.getRole())));
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
