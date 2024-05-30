package org.eventorganizer.app.views.eventView;

import org.eventorganizer.app.entity.Event;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;
import lombok.Getter;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;

public class EventDetailsView extends VerticalLayout {

    private Event event;

    MapView mapView = new MapView();
    Binder<Event> binder = new BeanValidationBinder<>(Event.class);

    TextField eventId;
    TextField eventName;
    DateTimePicker eventBeginDate;
    DateTimePicker eventEndDate;
    TextArea eventDescription;
    TextField locationQueryString;

    Button editButton = new Button("Edit", new Icon(VaadinIcon.PENCIL));
    Button saveButton = new Button( "Save", new Icon(VaadinIcon.CHECK));
    Button deleteButton = new Button("Delete", new Icon(VaadinIcon.ERASER));
    Button closeButton = new Button("Close", new Icon(VaadinIcon.CLOSE));

    private boolean checkClass(Class<?> fieldType){
        return (fieldType == TextField.class) ||
                (fieldType == DateTimePicker.class) ||
                (fieldType == TextArea.class);
    }

    public EventDetailsView(){
        binder.bindInstanceFields(this);
        configureEventView();

    }

    private Component createButtonsLayout() {
        editButton.getStyle().set("color", "white");
        saveButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        deleteButton.getStyle().set("color", "lightcoral");
        closeButton.addThemeVariants(ButtonVariant.LUMO_ERROR);

        editButton.addClickListener(clickEvent -> setFields(true));
        saveButton.addClickListener(clickEvent -> {
            try {
                validateAndSave();
            } catch (ValidationException e) {
                throw new RuntimeException(e);
            }
        });
        deleteButton.addClickListener(clickEvent -> fireEvent(new DeleteEvent(this, event)));
        closeButton.addClickListener(clickEvent -> {binder.readBean(event); setFields(false); });

        return new HorizontalLayout(editButton, saveButton, deleteButton, closeButton);
    }

    private void validateAndSave() throws ValidationException {
        //Applying changes to the text fields
        if (Optional.ofNullable(event).isPresent()) {
            binder.writeBean(event);
            fireEvent(new SaveEvent(this, event));
        }
    }

    /**
     * Vaadin Java Classes to modify the html attribute on html input fields as defined by Vaadin
     * this applies on to the class, but logic can also be created and generified.
     * @param enabled
     */
    protected void setFields(boolean enabled){
        Arrays.stream(this.getClass().getDeclaredFields())
                .filter(f -> checkClass(f.getType()))
                .map(field -> {
                    try {
                        field.setAccessible(true);
                        if(Optional.ofNullable(field.get(this)).isEmpty())
                            field.set(this,field.getType().getDeclaredConstructor().newInstance());
                        return field.get(this);
                    } catch (IllegalAccessException | InstantiationException |
                             InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(field ->{
//        for (Object field : fields ){
            if (field instanceof TextField) {
                ((TextField)field).setEnabled(enabled);
            }
            if (field instanceof TextArea) {
                ((TextArea)field).setEnabled(enabled);
            }
            if (field instanceof DateTimePicker) {
                ((DateTimePicker)field).setEnabled(enabled);
            }
        }
        );
    }

    private void configureEventView() {
        setFields(false);
        configureMapView();
        HorizontalLayout nameAndDatesLayout = new HorizontalLayout(eventName,eventBeginDate,eventEndDate);
        HorizontalLayout descriptionAndLocation = new HorizontalLayout(eventDescription, mapView);
        nameAndDatesLayout.setSizeFull();
        nameAndDatesLayout.setHeight("5em");
        descriptionAndLocation.setSizeFull();
        descriptionAndLocation.setHeight("20em");
        eventName.setWidth("33.3%");
        eventBeginDate.setWidth("33.3%");
        eventEndDate.setWidth("33.3%");
        eventName.setLabel("Event Name");
        eventBeginDate.setLabel("Event Start Date");
        eventEndDate.setLabel("Event End Date");
        eventDescription.setWidth("30%");
        eventDescription.setHeight("100%");
        eventDescription.getStyle().set("padding", "0px");
        eventDescription.setLabel("Event Description");
        locationQueryString.setId("myQuery");
        locationQueryString.getStyle().set("visibility","hidden");

//        mapView.showMap(locationQueryString.getValue());
        add(createButtonsLayout());
        add(nameAndDatesLayout);
        add(descriptionAndLocation);
        setClassName("event-view");
        getStyle().set("color","white");
        setSizeFull();
    }

    public void configureMapView(){
        mapView.setSizeFull();
        mapView.setMaxHeight("100%");
        mapView.setMaxWidth("30%");
    }


    public void setEvent(Event event){
        this.event = event;
        binder.readBean(event);
        setFields(false);
        System.out.println("Location in Java" + locationQueryString.getValue());
        MapView.showMap(locationQueryString.getValue());
    }

    @Getter
    public static abstract class DetailsViewEvent extends ComponentEvent<EventDetailsView>{

        private final Event event;

        /**
         * Creates a new frontend event-function using the given source and indicator whether the
         * event originated from the client side or the server side.
         *
         * @param source     the source component
         * @param event <code>true</code> if the event originated from the client
         *                   side, <code>false</code> otherwise
         */
        protected DetailsViewEvent(EventDetailsView source, Event event) {
            super(source, false);
            this.event = event;
        }

    }

    public static class SaveEvent extends DetailsViewEvent {
        protected SaveEvent(EventDetailsView source, Event event) {
            super(source, event);
        }
    }

    public static class DeleteEvent extends DetailsViewEvent {
        protected DeleteEvent(EventDetailsView source, Event event) {
            super(source, event);
            source.setEvent(new Event());
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(
            Class<T> eventType, ComponentEventListener<T> listener){
        return getEventBus().addListener(eventType, listener);
    }



}


