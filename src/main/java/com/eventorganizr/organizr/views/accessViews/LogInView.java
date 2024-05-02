package com.eventorganizr.organizr.views.accessViews;

import com.eventorganizr.organizr.service.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;


@Route("/login")
@AnonymousAllowed
public class LogInView extends VerticalLayout
        implements BeforeEnterObserver
{
    private final UserService userService;
    private final LoginForm loginForm = new LoginForm();
    private final VerticalLayout registerNewUser = new VerticalLayout();
    private final HorizontalLayout frontDesk = new HorizontalLayout();

    public LogInView(UserService userService){
        this.userService = userService;
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        frontDesk.add(registerNewUser,loginForm);
        frontDesk.setAlignItems(Alignment.CENTER);
        configureRegisterNewUser();

        loginForm.setAction("login");
        add(
                new H1("Event Organizer App"),
                frontDesk
        );
    }

    public void configureRegisterNewUser(){
        registerNewUser.setAlignItems(Alignment.CENTER);
        registerNewUser.setWidth("300px");
        H3 description = new H3("Do you want to try ?");
        Button signUpNow = new Button("Sign Up Now");


        signUpNow.setIcon(new Icon(VaadinIcon.USER));
        signUpNow.addClickListener(event -> UI.getCurrent().navigate("sign-up"));
        signUpNow.getStyle().set("color", "greenyellow");



        registerNewUser.add(description, signUpNow);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            loginForm.setError(true);
        }
    }
}

