package org.eventorganizer.app.webClient;

import com.vaadin.flow.server.VaadinSession;
import org.springframework.stereotype.Component;

@Component
public class SessionIDResolver {

    private static String JSESSION = "JSESSIONID=";

    public String sessionId(){
        if(VaadinSession.getCurrent() == null)
            return "";
        return JSESSION + VaadinSession.getCurrent().getSession().getId();
    }
}
