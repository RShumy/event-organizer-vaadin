package org.eventorganizer.app.views.eventViews;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@JsModule("./map-view-partial.ts")
public class MapView extends VerticalLayout {

    MapView(){
        this.setPadding(false);
        Div mapHolder = new Div();
        mapHolder.setId("myMap");
        mapHolder.setSizeFull();
        if (mapHolder.isVisible()) {
            mapHolder.getElement().getStyle().set("border-radius", "10px");
            mapHolder.getElement().getStyle().set("border", "5px solid white");
        }
        add(mapHolder);
    };

    public static void showMap(String locationQuery){
        UI.getCurrent().getPage().executeJs("ShowMap($0)", locationQuery);
    }
}
