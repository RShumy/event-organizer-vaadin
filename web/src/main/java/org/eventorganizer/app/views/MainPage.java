package org.eventorganizer.app.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.PageTitle;

import javax.annotation.security.PermitAll;

@PermitAll
@PageTitle("Main Page")
public class MainPage extends AppLayout {

    public MainPage() {
//        createDrawer();
//        addClassName("list-view");
//        setSpacing(false);
//        setSizeFull();
//        setJustifyContentMode(JustifyContentMode.CENTER);
//        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//        getStyle().set("text-align", "center");
//        add(eventMainView);
    }

//    private void createDrawer() {
//        RouterLink eventMainView = new RouterLink("Event Main View", EventMainView.class);
//        eventMainView.setHighlightCondition(HighlightConditions.sameLocation());
//
//        addToDrawer(new VerticalLayout(eventMainView));
//    }


}