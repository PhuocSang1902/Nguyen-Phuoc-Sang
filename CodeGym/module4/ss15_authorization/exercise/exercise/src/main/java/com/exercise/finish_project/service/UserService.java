package com.exercise.finish_project.service;

import com.exercise.finish_project.model.AppRole;
import com.exercise.finish_project.model.AppUser;
import com.exercise.finish_project.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = this.userRepository.findByUsername(username);

        if (user == null){
            System.out.println("User name " + username + " not found !");
            throw new UsernameNotFoundException("User name " + username + "not found in the database");
        }

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        for (AppRole appRole : user.getRoles()){
            grantedAuthorityList.add(new SimpleGrantedAuthority(appRole.getName()));
        }


        UserDetails userDetails = new User(user.getUsername(), user.getEncrytedPassword(), grantedAuthorityList);

        return userDetails;


    }
}
