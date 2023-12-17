package com.eventorganizr.organizr.security;

import com.eventorganizr.organizr.service.UserService;
import com.vaadin.flow.server.VaadinServletRequest;
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
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
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
import org.springframework.security.core.context.SecurityContext;
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
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.util.UrlPathHelper;
import org.yaml.snakeyaml.reader.StreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.*;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig
        extends VaadinWebSecurity
{


    private final UserPrincipalDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    SecurityConfig(UserPrincipalDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        System.out.println(
                "From Security Config -> the User Detail Service hash is: " +
                        System.identityHashCode(userDetailsService.getUserService()));
    }

//    @Bean
//    @Primary
//    public AuthenticationManagerBuilder authManagerBuilder(AuthenticationManagerBuilder authManager) throws Exception {
//        return authManager.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder()).and();
//    }

    // Added afterwards
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder); // Choose your preferred password encoder
        return provider;
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
                            .antMatchers("/VAADIN/**","/h2/**","/image/**","/favicon.ico")
                                .permitAll()
                            .antMatchers("/api/**").authenticated()
                            .anyRequest().authenticated()
                ).exceptionHandling()
                .and().httpBasic().and()
                .headers(headers -> headers.frameOptions().sameOrigin())
                .userDetailsService(userDetailsService)
                .formLogin()
                .and().logout()
                .and()
                .build();
    }



//      No PasswordEncoder for now as Registering methods and classed are not yet present
//      and Auto-populating the Data Base with Users is done via Sql Script
    @Bean
    public static PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder();}


}
