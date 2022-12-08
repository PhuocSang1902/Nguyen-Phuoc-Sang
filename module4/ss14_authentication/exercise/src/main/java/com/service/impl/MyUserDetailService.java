package com.service.impl;

import com.model.MyUserDetail;
import com.model.User;
import com.repository.IUserRepository;
import com.service.IMyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements IMyUserDetailService {
    @Autowired
    IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User name: " + username + " not found");
        }

        return new MyUserDetail(user);
    }
}
