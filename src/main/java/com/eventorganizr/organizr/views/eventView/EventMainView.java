package com.eventorganizr.organizr.views.eventView;

import com.eventorganizr.organizr.entity.Event;
import com.eventorganizr.organizr.service.EventService;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.grid.ItemClickEvent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.Optional;

@Route(value = ""
//        , layout = MainPage.class
)
public class EventMainView extends VerticalLayout {



    private final EventListView eventList = new EventListView();

    private final EventDetailsView eventDetailsView = new EventDetailsView();



    HorizontalLayout eventListAndDetailView = new HorizontalLayout(eventList,eventDetailsView);

    private final EventService eventService;


    public EventMainView(EventService eventService){
        this.eventService = eventService;

        addClassName("event-main-view");

        updateEvents();
        configureEventDetailsView();
        setSizeFull();

        add(getContent());
    }


    private void configureEventDetailsView() {
        eventList.addListener(EventListView.AddNewEvent.class, event -> openEventDetailsView(new Event()));
        eventList.addListener(EventListView.SelectedEvent.class, event -> openEventDetailsView(event.getEvent()));
        eventDetailsView.setSizeFull();
        eventDetailsView.addListener(EventDetailsView.SaveEvent.class,this::saveEvent);
        //            closeEventDetailsView();
        eventDetailsView.addListener(EventDetailsView.DeleteEvent.class, this::deleteEvent);
        eventDetailsView.closeButton.addClickListener(click -> closeEventDetailsView());
//        eventDetailsView.addListener();
//        eventDetailsView.add();

    }

    private void deleteEvent(EventDetailsView.DeleteEvent event) {
        eventService.delete(event.getEvent().getEventId());
        updateEvents();
    }

    private void saveEvent(EventDetailsView.SaveEvent event) {
        if (Optional.ofNullable(event.getEvent().getEventId()).isPresent()) {
            eventService.updateEvent(event.getEvent().getEventId(), event.getEvent());
        }
        else eventService.saveEvent(event.getEvent());
        updateEvents();
    }


    public Component getContent() {
        configureEventDetailsView();
        eventListAndDetailView.setSizeFull();
        eventListAndDetailView.setFlexGrow(1, eventList);
        eventListAndDetailView.setFlexGrow(4, eventDetailsView);
        eventDetailsView.setVisible(false);
        return eventListAndDetailView;
    }

    public void openEventDetailsView(Event event){
        eventDetailsView.setEvent(event);
        if(Optional.ofNullable(event.getEventName()).orElse("").equals(""))
            eventDetailsView.setFields(true);
        eventList.setWidth("25%");
        eventDetailsView.setVisible(true);
    }

    public void closeEventDetailsView(){
        eventDetailsView.setVisible(false);
        eventListAndDetailView.setFlexGrow(0,eventDetailsView);
    }

    private void updateEvents() {
        eventList.updateEvents(eventService.getEvents());
    }


}
