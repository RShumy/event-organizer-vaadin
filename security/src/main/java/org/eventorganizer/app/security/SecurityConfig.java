package org.eventorganizer.app.security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    private final UserPrincipalDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserPrincipalDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    /**
     * Main Security Filter Chain for Spring Security 6 + Vaadin 24.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Apply Vaadin’s default security rules (static resources, internal endpoints)

        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(
                                // Vaadin internal framework endpoints
                                "/?v-r=init**",
                                "/*",
                                "/VAADIN/**",
                                "/UIDL/**",
                                "/HEARTBEAT/**",
                                "/@flow/**",
                                "/@vite/**",
                                "/frontend/**",
                                "/offline-stub.html"
                        )
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                            // Apparently in Vaadin 24 will break without permitting the root "/*"
                            // what an abomination
                                "/*",
                                "/?v-r=init**",
                                "/?v-r=uidl**",
                                "/login",
                                "/VAADIN/**",
                                "/VAADIN/@vite/**",
                                "/VAADIN/@fs/**",
                                "/VAADIN/build/**",
                                "/VAADIN/push/**",
                                "/VAADIN/generated/**",
                                "/VAADIN/themes/**",
                                "/icons/**",
                                "/@vite/**",
                                "/frontend/**",
                                "/manifest.webmanifest",
                                "/sw.js",
                                "/offline.html",
                                "/index.html",
                                "/@flow/**",
                                "/offline-stub.html",
                                "/h2/**"
                                )
                        .permitAll()

                        // API (authenticated)
                        .requestMatchers(HttpMethod.GET, "/api/**").authenticated()
                        .requestMatchers(HttpMethod.POST, "/api/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/**").authenticated()

                        // Vaadin views: all other routes authenticated
                        .anyRequest().authenticated()
                )
                .userDetailsService(userDetailsService)
                // Enable H2 console
                .headers(headers -> headers.frameOptions(options -> options.sameOrigin()))
                .logout(logout -> logout
                        .logoutSuccessHandler((req, res, auth) ->
                                res.setStatus(HttpServletResponse.SC_OK))
                        .deleteCookies("JSESSIONID")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                ).formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder();}

}
