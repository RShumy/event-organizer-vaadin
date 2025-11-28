//package org.eventorganizer.app.security;
//
//import com.vaadin.flow.server.VaadinServletRequest;
//import com.vaadin.flow.server.VaadinServletResponse;
//import com.vaadin.flow.server.VaadinSession;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//public class SecurityServiceWithVaadin {
//
//    private Authentication getAuthentication() {
//        return SecurityContextHolder.getContext().getAuthentication();
//    }
//
//    public UserDetails getAuthenticatedUser() throws IOException {
//        Authentication authentication = getAuthentication();
//
//        if (authentication == null || !authentication.isAuthenticated()) {
//            VaadinServletResponse.getCurrent().sendRedirect("/login");
//            return null;
//        }
//
//        Object principal = authentication.getPrincipal();
//        return (principal instanceof UserDetails) ? (UserDetails) principal : null;
//    }
//
//    public void logout() throws IOException {
//        VaadinSession.getCurrent().getSession().invalidate();
//        System.out.println("LOGOUT HANDLER IS CALLED");
//        new SecurityContextLogoutHandler().logout(VaadinServletRequest.getCurrent(), null, getAuthentication());
//    }
//
//}