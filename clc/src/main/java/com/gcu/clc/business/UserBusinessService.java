package com.gcu.clc.business;

import java.util.ArrayList;
import java.util.List;

import com.gcu.clc.data.UserDataService;
import com.gcu.clc.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserBusinessService implements UserDetailsService{
    @Autowired
    private UserDataService service;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = service.findByUsername(username);
        if(user != null){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getEmail(), user.getPassword(), authorities);
        }
        return null;
    }
}
