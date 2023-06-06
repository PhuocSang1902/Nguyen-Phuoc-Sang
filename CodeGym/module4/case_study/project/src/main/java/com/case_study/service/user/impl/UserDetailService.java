//package com.case_study.service.user.impl;
//
//import com.case_study.model.user.Role;
//import com.case_study.model.user.UserEmployee;
//import com.case_study.repository.user.IUserRepository;
//import com.case_study.service.user.IUserDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class UserDetailService implements IUserDetailService {
//    @Autowired
//    private IUserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserEmployee user = this.userRepository.findByUsername(username);
//
//        if (user == null){
//            System.out.println("User name " + username + " not found !");
//            throw new UsernameNotFoundException("User name " + username + "not found in the database");
//        }
//
//        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
//
//        for (Role appRole : user.getRoleSet()){
//            grantedAuthorityList.add(new SimpleGrantedAuthority(appRole.getName()));
//        }
//
//
//        UserDetails userDetails = new User(user.getUsername(), user.getPassword(), grantedAuthorityList);
//
//        return userDetails;
//    }
//}
