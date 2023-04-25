package com.eventorganizr.organizr.views;

import com.eventorganizr.organizr.views.eventView.EventMainView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import javax.annotation.security.PermitAll;

@PermitAll
@PageTitle("Main Page")
public class MainPage extends AppLayout {

    public MainPage() {
//        createDrawer();
//        addClassName("list-view");
//        setSpacing(false);
//
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