package org.eventorganizer.app.controller;


import org.eventorganizer.app.entity.Event;
import org.eventorganizer.app.entity.Participant;
import org.eventorganizer.app.entity.User;
import org.eventorganizer.app.entity.compositeKeys.ParticipantKey;
import org.eventorganizer.app.service.ParticipantService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping(path = "events_for_user/{userId}")
    public List<Event> getEventsForUser(@PathVariable Long userId){
        return participantService.getEventsForUser(userId);
    }

    @GetMapping(path = "users_at_event/{eventId}")
    public List<User> getUsersAtEvent(@PathVariable Long eventId){
        return participantService.getUsersByEvent(eventId);
    }

    @GetMapping
    public List<Participant> getAllParticipants(){
        return participantService.getAllParticipants();
    }

    @GetMapping(path = "byEventId/{eventId}")
    public List<Participant> getParticipantsByEventId(@PathVariable Long eventId){
        return participantService.findParticipantsByEventId(eventId);
    }


    @PostMapping(path = "participantId")
    public void saveParticipant(@RequestBody ParticipantKey participantId){
        participantService.saveParticipant(participantId);
    }

    @DeleteMapping(path = "participantId")
    @Transactional
    public void deleteParticipant(@RequestBody ParticipantKey participantId){
        participantService.deleteById(participantId);
        System.out.println("From Controller: "+participantId);
    }

}
