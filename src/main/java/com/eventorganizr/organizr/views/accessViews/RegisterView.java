package com.eventorganizr.organizr.views.accessViews;

import com.eventorganizr.organizr.entity.User;
import com.eventorganizr.organizr.service.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.Arrays;
import java.util.Optional;

@Route(value = "sign-up")
@AnonymousAllowed
public class RegisterView extends VerticalLayout {

    private final UserService userService;

    private User user = new User();
    Binder<User> userBinder = new BeanValidationBinder<>(User.class);

    H1 registerHeader = new H1("Register New User");
    Button submit = new Button("Submit and Register", new Icon(VaadinIcon.PLUS));


    TextField userName;
    // These two (firstName , lastName) also need validations
    TextField firstName;
    TextField lastName;

    TextField email;
    PasswordField password;

    PasswordField passwordRepeatCheck = new PasswordField();

    public RegisterView(UserService userService){
        this.userService = userService;
        userBinder.bindInstanceFields(this);
        userBinder.readBean(user);

        add(registerHeader);
        configureRegisterView();
    }

    private void configureRegisterView() {
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setFiledLabels();
        configureSubmitButton();
        add(userName, firstName, lastName, email, password, passwordRepeatCheck, submit);
    }

    private void setFiledLabels() {
        userName.setLabel("User Name");
        userName.setRequired(true);
        userName.addValueChangeListener(event -> userNameCheckStyle());
        firstName.setLabel("First Name");
        lastName.setLabel("Last Name");
        email.setLabel("Email");
        email.setRequired(true);
        email.addValueChangeListener(event -> emailPatternCheckStyle());
        password.setLabel("Password");
        password.setRequired(true);
        password.addValueChangeListener(event -> passwordValueChangeCheckStyle());
        passwordRepeatCheck.setLabel("Confirm Password");
        passwordRepeatCheck.addValueChangeListener(event -> passwordValueChangeCheckStyle());
    }

    private void configureSubmitButton() {
        H3 pleaseReview = new H3("Please review the required fields");
        pleaseReview.setId("PleaseReview");
        this.submit.addClickListener(event -> {
            if(validationChecks()) saveUser();
            else if (this.getChildren().noneMatch(c -> c.getId().get().equals("PleaseReview")))
                add(pleaseReview);
        });
    }

    private void saveUser() {
        if(Optional.ofNullable(user).isPresent()) {
            try {
                userBinder.writeBean(user);
            } catch (ValidationException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
            System.out.println("User after Save User is clicked: " + user);
        }
        user.setActive(true);
        userService.saveUser(user);
        userService.updatePassword(user);
        UI.getCurrent().navigate("login");
    }

    private boolean validationChecks() {
        System.out.println("-- UserName is Not Empty: " + !userName.getValue().isEmpty());
        System.out.println("-- Email matches email regex: " + emailMatchesPattern());
        System.out.println("-- Passwords match: " + passwordMatchCheck());
        return userNameCheck() && emailMatchesPattern() && passwordMatchCheck();
    }

    private void userNameCheckStyle(){
        if(!userNameCheck()){
            userName.setInvalid(true);
            userName.setAllowedCharPattern("[A-Za-z_0-9]");
            userName.setMinLength(3);
            userName.setErrorMessage("Minimum 3 characters, No Spaces Allowed, No Special Characters Allowed, Underscore allowed");
        }
        else userName.setInvalid(false);
    }


    private void passwordValueChangeCheckStyle(){
        if (passwordMatchCheck()) {
            password.setInvalid(false);
            passwordRepeatCheck.setInvalid(false);
            passwordRepeatCheck.setErrorMessage(null);
        }
        else {
            password.setInvalid(true);
            passwordRepeatCheck.setInvalid(true);
            passwordRepeatCheck.setErrorMessage("Passwords do not match");
        }
    }

    private void emailPatternCheckStyle(){
        if(emailMatchesPattern()) {
            email.getStyle().set("color", "darkseagreen");
            email.setHelperText("Email pattern matches now!");
        }
        else {
            email.setInvalid(true);
            email.setHelperText("Example: user@provider.com");
            email.setErrorMessage("Email does not respect proper format");
        }
    }

    private boolean userNameCheck(){
        return !userName.getValue().isEmpty() && userName.getValue().length() >= 3 &&
                userName.getValue().matches("[a-zA-Z0-9_]+");
    }

    private boolean emailMatchesPattern(){
        return email.getValue().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    }

    private boolean passwordMatchCheck(){
        return password.getValue().equals(passwordRepeatCheck.getValue()) &&
                (!password.getValue().isEmpty() && !passwordRepeatCheck.getValue().isEmpty());
    }



}
