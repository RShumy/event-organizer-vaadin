package org.eventorganizer.app.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SecurityService {

    public SecurityService(){}

    public static boolean isUserLoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return false;
        }
        if (!auth.isAuthenticated()) {
            return false;
        }
        // treat anonymous authentication as not logged in
        String principalClass = auth.getPrincipal() != null ? auth.getPrincipal().getClass().getName() : "";
        return !(principalClass.equals("org.springframework.security.authentication.AnonymousAuthenticationToken"));
    }

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static UserDetails getAuthenticatedUser() throws IOException {
        Authentication authentication = getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        return (principal instanceof UserDetails) ? (UserDetails) principal : null;
    }


    public static String getUsername() throws IOException {
        UserDetails ud = getAuthenticatedUser();
        return ud != null ? ud.getUsername() : null;
    }

    public static boolean hasRole(String role) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth.getAuthorities() == null) return false;
        return auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals(role) || a.getAuthority().equals("ROLE_" + role));
    }

    public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Authentication authentication = getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
    }

}