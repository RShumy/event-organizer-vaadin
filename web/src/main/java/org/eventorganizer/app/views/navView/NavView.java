package org.eventorganizer.app.views.navView;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eventorganizer.app.security.SecurityService;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;

import static java.util.Objects.isNull;

public class NavView  extends HorizontalLayout {

    private SecurityService securityService;

    Button logout = new Button("Log out",
            e -> {
                System.out.println("SHOULD LOG OUT !!!!!!");
                logout();
            }
    );

    private void logout(){
        try {
            HttpServletRequest request =
                    (HttpServletRequest) VaadinRequest.getCurrent();
            HttpServletResponse response =
                    (HttpServletResponse) VaadinResponse.getCurrent();
            securityService.logout(request, response);
            UI.getCurrent().getPage().setLocation("/login");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    Div userDiv = new Div();

    public NavView(){
        setWidth(100, Unit.PERCENTAGE);
        userDiv.setSizeFull();
        try {
            UserDetails userDetails = SecurityService.getAuthenticatedUser();
            if ( isNull(userDetails) ) logout();
            userDiv.setText("Hello " +
                    SecurityService.getAuthenticatedUser().getUsername()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logout.setWidth("100px");
        add(userDiv,logout);
    }
}
