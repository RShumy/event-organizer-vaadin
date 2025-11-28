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

import java.io.IOException;

public class NavView  extends HorizontalLayout {

    private SecurityService securityService;

    Button logout = new Button("Log out",
            e -> {
                System.out.println("SHOULD LOG OUT !!!!!!");
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
