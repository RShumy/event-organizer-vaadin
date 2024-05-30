package org.eventorganizer.app.views.eventView;


import org.eventorganizer.app.entity.Event;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.shared.Registration;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class EventListView extends VerticalLayout {

    Grid<Event> eventGrid = new Grid<>(Event.class, false);

    public EventListView(List<Event> events){
//        this.events = events;

        addClassName("event-list");
        setSizeFull();

//        configureEventList();
        configureEventGrid();

        updateEvents(events);

        add(eventGrid);
    }

    public EventListView(){
        this(Collections.emptyList());
    }

    protected void updateEvents(List<Event> events) {
        eventGrid.setItems(events);
//        eventListBox.setItems(events);
    }

    private void configureEventGrid() {
        eventGrid.addClassName("event-grid");
        setSizeFull();

        eventGrid.addColumn(createEventRenderer()).setHeader(getEventHeader());
        eventGrid.getColumns().forEach( col -> col.setAutoWidth(true));
        eventGrid.addItemClickListener(event -> fireEvent(new SelectedEvent(this, event.getItem())));
    }

    private Component getEventHeader(){
        HorizontalLayout eventsHeader = new HorizontalLayout();
        Span eventsHeaderText = new Span("Events");
        eventsHeaderText.getStyle().set("align-self","center").set("color","white");
        Button addEventButton = new Button();
        Icon plusIcon = new Icon("plus");
        plusIcon.setColor("white");
        addEventButton.addClickListener(click -> fireEvent(new AddNewEvent(this)));
        addEventButton.setMaxHeight("2em");
        addEventButton.setMaxWidth("2em");
        addEventButton.getStyle().set("border-radius","10%");
        addEventButton.setIcon(plusIcon);

        eventsHeader.add(eventsHeaderText,addEventButton);
        eventsHeader.setFlexGrow(4,eventsHeaderText);
        eventsHeader.setFlexGrow(1,addEventButton);

        return eventsHeader;
    }

    private static Renderer<Event> createEventRenderer() {
        DateTimeFormatter formatter = getDateTimeFormatter();
        return LitRenderer.<Event> of(
                        "<vaadin-horizontal-layout style=\"align-items: center;\">"
                                + "  <vaadin-vertical-layout " +
                                "           style=\"line-height: var(--lumo-line-height-m); " +
                                "                   color: white" +
                                "   \">"
                                + "    <span> ${item.eventName} </span>"
                                + "    <span style=\"font-size: var(--lumo-font-size-s); color: var(--lumo-contrast-80pct);\">"
                                + "      Begins ${item.eventBeginDate}" + "    </span>"
                                + "    <span style=\"font-size: var(--lumo-font-size-s); color: var(--lumo-contrast-80pct);\">"
                                + "      Ends ${item.eventEndDate}" + "    </span>"
                                + "  </vaadin-vertical-layout>"
                                + "</vaadin-horizontal-layout>")
                .withProperty("eventName", Event::getEventName)
                .withProperty("eventBeginDate", event -> event.getEventBeginDate().format(formatter))
                .withProperty("eventEndDate", event -> event.getEventEndDate().format(formatter));
    }

    private static DateTimeFormatter getDateTimeFormatter(){
        return DateTimeFormatter.ofPattern("dd-MMM-yyyy 'at' HH:mm");
    }

    @Getter
    public static abstract class ListViewEvent extends ComponentEvent<EventListView> {
        private final Event event;

        protected ListViewEvent(EventListView source, Event event) {
            super(source, false);
            this.event = event;
        }
    }

    public static class AddNewEvent extends ListViewEvent{
        protected AddNewEvent(EventListView source){
            super(source, null);
        }
    }

    public static class SelectedEvent extends ListViewEvent{
        protected SelectedEvent(EventListView source, Event event){
            super(source, event);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(
            Class<T> eventType, ComponentEventListener<T> listener){
        return getEventBus().addListener(eventType, listener);
    }


}
