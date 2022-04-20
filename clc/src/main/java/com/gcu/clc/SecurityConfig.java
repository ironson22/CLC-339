package com.gcu.clc;

import javax.servlet.http.HttpSession;

import com.gcu.clc.business.UserBusinessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired UserBusinessService service ;
    
    /** 
     * @return BCryptPasswordEncoder
     */
    @Autowired 
//Encodes the password
    @Bean(name="passwordEncoder")
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    
    /** 
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable()
        .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/products/**", "/service/**")
            .authenticated()
            .and()
        .authorizeRequests()
            .antMatchers("/", "/images/**")
            .permitAll()
            .and()
        .formLogin()
            .loginPage("/login")
            .usernameParameter("username")
            .passwordParameter("password")
            .permitAll()
            .defaultSuccessUrl("/", true)
            .and()
        .logout()
            .logoutUrl("/logout")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .permitAll().logoutSuccessUrl("/");
    }

    
    /** 
     * @param auth
     * @throws Exception
     */
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
        .userDetailsService(service)
        .passwordEncoder(passwordEncoder);
    }
}
