package com.eventorganizr.organizr.security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinContext;
import com.vaadin.flow.server.VaadinServletRequest;
import com.vaadin.flow.server.VaadinServletResponse;
import com.vaadin.flow.spring.security.VaadinWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;

@Component
public class SecurityService {

    private static final String LOGOUT_SUCCESS_URL = "/login";

    private SecurityContext getSecurityContext(){
        return SecurityContextHolder.getContext();
    }

    public UserDetails getAuthenticatedUser() throws IOException {
        Object principal = getSecurityContext().getAuthentication().getPrincipal();
        if (principal == null) {
            VaadinServletResponse.getCurrent().sendRedirect("/login");
            return null;
        }
        if (principal instanceof UserDetails) {
            return (UserDetails) principal;
        }
        // Anonymous or no authentication.
        return null;
    }

    public void logout() throws IOException {
        UI.getCurrent().getPage().setLocation(LOGOUT_SUCCESS_URL);
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        System.out.println("LOGOUT HANDLER IS CALLED");
        logoutHandler.logout(
                VaadinServletRequest.getCurrent().getHttpServletRequest(),
                null,
                getSecurityContext().getAuthentication());
    }

}