package com.eventorganizr.organizr.controller;


import com.eventorganizr.organizr.entity.Event;
import com.eventorganizr.organizr.entity.Participant;
import com.eventorganizr.organizr.entity.User;
import com.eventorganizr.organizr.entity.compositeKeys.ParticipantKey;
import com.eventorganizr.organizr.service.ParticipantService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
