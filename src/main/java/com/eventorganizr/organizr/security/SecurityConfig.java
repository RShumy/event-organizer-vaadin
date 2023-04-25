package com.eventorganizr.organizr.security;

import com.eventorganizr.organizr.service.UserService;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.*;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig
        extends VaadinWebSecurity
{

    //TODO: Implement getting the DataSource correctly and setting up the JDBC UserDetailsManager with the Password Encoder

    UserPrincipalDetailsService userDetailsService;

    SecurityConfig(UserPrincipalDetailsService userDetailsService){
        this.userDetailsService = userDetailsService;
        System.out.println(
                "From Security Config -> the User Detail Service hash is: " +
                        System.identityHashCode(userDetailsService.getUserService()));
    }

    @Bean
    @Primary
    public AuthenticationManagerBuilder authManagerBuilder(AuthenticationManagerBuilder authManager) throws Exception {
        return authManager.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder()).and();
    }

    @Bean(name = "VaadinSecurityFilterChainBean")
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
//                I will have to figure out why xhr payload isn't processed or why the response is invalidated
//                It has something to do with:
//                    Vaadin and Spring both handle CSRF independently, and these implementations are not compatible.
//                Prior to Vaadin 21, the solution was usually to turn off CSRF in Spring Security and let Vaadin handle it.
//                The Vaadin 21 security helper is finer-grained, only disabling Spring CSRF for the paths Vaadin uses,
//                and keeping it enabled for all other paths.
//                Link Source: https://vaadin.com/blog/securing-vaadin-apps-with-spring-security-best-practices
//                Tried:
//                
//                .csrf(csrf -> csrf.ignoringAntMatchers(
//                        "/h2/**")
//                        .ignoringAntMatchers("/VAADIN/**")
//                        .ignoringAntMatchers("/image/**")
//                )

                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(auth ->
                        auth
                                .antMatchers("/VAADIN/**").permitAll()
                                .antMatchers("/h2/**").permitAll()
                                .antMatchers("/image/**").permitAll()
                                .antMatchers("/api/**").authenticated()
                                .anyRequest().authenticated()
                ).exceptionHandling()
                .and().httpBasic().and()
                .headers(headers -> headers.frameOptions().sameOrigin())
                .userDetailsService(userDetailsService)
                .formLogin()
                .and().build();
    }



//      No PasswordEncoder for now as Registering methods and classed are not yet present
//      and Auto-populating the Data Base with Users is done via Sql Script
    @Bean
    public static PasswordEncoder passwordEncoder(){ return NoOpPasswordEncoder.getInstance();}



}
