package com.case_study.config;

import com.case_study.service.user.IUserDetailService;
import com.case_study.service.user.impl.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IUserDetailService userDetailsService;

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
////        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
////        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
////        http.authorizeRequests().antMatchers("/admin").access("hasAnyRole('ROLE_ADMIN')");
////        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//        http.authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .and().formLogin()
////                .loginPage("")
//                .defaultSuccessUrl("/userInfo")
//                .failureUrl("/login?error=true")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
//
//        http.authorizeRequests().and()
//                .rememberMe().tokenRepository(this.persistentTokenRepository())
//                .tokenValiditySeconds(1 * 24 * 60 * 60);
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()

                .formLogin()
//                .loginPage("/")
                .defaultSuccessUrl("/", true).permitAll()

                .and().authorizeRequests().antMatchers("/contract","/customer/*","/facility").hasRole("ADMIN")
                .and().authorizeRequests().antMatchers( "/customer").hasAnyRole("USER","ADMIN")
                .and().authorizeRequests().antMatchers("/").permitAll()

                .and()
                .authorizeRequests()
                .anyRequest().authenticated()

                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll();
        http.authorizeRequests().and().rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(1 * 24 * 60 * 60);
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
