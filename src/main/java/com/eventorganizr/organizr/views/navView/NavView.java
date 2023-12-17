package com.eventorganizr.organizr.views.navView;

import com.eventorganizr.organizr.security.SecurityService;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import java.io.IOException;

public class NavView  extends HorizontalLayout {

    private SecurityService securityService;

    Button logout = new Button("Log out",
            e -> {
                System.out.println("SHOULD LOG OUT !!!!!!");
                try {
                    securityService.logout();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
    );

    Div userDiv = new Div();

    public NavView(SecurityService securityService){
        this.securityService = securityService;
        setWidth(100, Unit.PERCENTAGE);
        userDiv.setSizeFull();
        try {
            userDiv.setText("Hello " +
                       securityService.getAuthenticatedUser().getUsername()
                    );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logout.setWidth("100px");
        add(userDiv,logout);
    }
}
