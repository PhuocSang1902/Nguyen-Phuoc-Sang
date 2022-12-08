package com.exercise.finish_project.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class WebUtils {
    public static String toString(User user){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Username:").append(user.getUsername());

        Collection<GrantedAuthority> authorityCollection = user.getAuthorities();
        if(authorityCollection != null && !authorityCollection.isEmpty()){
            stringBuilder.append(" (");
            boolean first = true;
            for(GrantedAuthority grantedAuthority : authorityCollection){
                if(first){
                    stringBuilder.append(grantedAuthority.getAuthority());
                    first = false;
                }else {
                    stringBuilder.append(", ").append(grantedAuthority.getAuthority());
                }
            }
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }
}
