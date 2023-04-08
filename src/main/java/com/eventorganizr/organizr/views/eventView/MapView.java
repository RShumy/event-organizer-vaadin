package com.eventorganizr.organizr.views.eventView;

import com.eventorganizr.organizr.entity.Event;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;

import com.vaadin.flow.component.html.IFrame;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@JsModule("./map-view-partial.js")
public class MapView extends VerticalLayout {
    public Div mapView = new Div();

    MapView(){
        this.setPadding(false);
        mapView.setId("myMap");
        mapView.setSizeFull();
        mapView.getElement().getStyle().set("border", "2px solid white");
        add(mapView);
    };

    public void showMap(String locationQuery){
//        if (!locationQuery.isEmpty()) UI.getCurrent().getPage().executeJs("ShowMap($0, GetMap)", locationQuery);
        if (!locationQuery.isEmpty()) UI.getCurrent().getPage().executeJs("ShowMap($0)", locationQuery);
    }
}
