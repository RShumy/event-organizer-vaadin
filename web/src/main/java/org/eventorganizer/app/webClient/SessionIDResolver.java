package org.eventorganizer.app.webClient;

import com.vaadin.flow.spring.SpringVaadinSession;
import org.springframework.stereotype.Component;

@Component
public class SessionIDResolver {

    private static String JSESSION = "JSESSIONID=";

    public String sessionId(){
        if(SpringVaadinSession.getCurrent() == null)
            return "";
        return JSESSION + SpringVaadinSession.getCurrent().getSession().getId();
    }
}
