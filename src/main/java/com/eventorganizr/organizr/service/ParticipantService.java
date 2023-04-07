package com.eventorganizr.organizr.service;

import com.eventorganizr.organizr.entity.*;
import com.eventorganizr.organizr.entity.compositeKeys.ParticipantKey;
import com.eventorganizr.organizr.repository.ParticipantConsumableRepository;
import com.eventorganizr.organizr.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    private final ParticipantConsumableRepository participantConsumableRepository;
    private final EventService eventService;
    private final UserService userService;
    public ParticipantService(ParticipantRepository participantRepository, ParticipantConsumableRepository participantConsumableRepository,
                              EventService eventService, UserService userService) {
        this.participantRepository = participantRepository;
        this.participantConsumableRepository = participantConsumableRepository;
        this.eventService = eventService;
        this.userService = userService;
    }

    public List<Participant> findParticipantsByEventId(Long eventId){
        return participantRepository.findAllByEventEventId(eventId);
    }

    public List<Participant> findParticipantsByUserId(Long userId){
        return participantRepository.findAllByUserUserId(userId);
    }

    public List<User> getUsersByEvent(Long eventId){
        try {
            return participantRepository.findAllByEventEventId(eventId)
                    .stream().map(Participant::getUser)
                    .collect(Collectors.toList());

//            return participantRepository.findAll().stream()
//                .filter((a)-> a.getParticipantID().getEventId().equals(eventId))
//                .map(Participant::getUser).collect(Collectors.toList());
        } catch(RuntimeException e) {
            throw new RuntimeException("Event has no participants");
        }
    }

    public List<Event> getEventsForUser(Long userId){
        try {
            return participantRepository.findAllByUserUserId(userId)
                    .stream().map(Participant::getEvent)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("User not participating at any Event");
        }
    }

    public List<Participant> getAllParticipants(){
        try { return participantRepository.findAll(); }
        catch (Exception e) {throw new RuntimeException("Something went wrong");}
    }

    public Participant findParticipantById(ParticipantKey participantId){
        return participantRepository.findByParticipantId(participantId);
    }

    public void saveParticipant(ParticipantKey participantId){
        Event event = eventService.findEvent(participantId.getEventId());
        User user = userService.findUser(participantId.getUserId());
        participantRepository.save(new Participant(event,user));
    }

    public void deleteById(ParticipantKey participantId){
        participantRepository.deleteByParticipantId(participantId);
//        deleteParticipant(participant);
    }


    // UNUSED

    private Participant findParticipantByIds(Long eventId, Long userId){
        return participantRepository.findByEvent_EventIdAndUser_UserId(eventId,userId);
    }
    public void saveParticipant(Event event, User user){
        participantRepository.save(new Participant(event,user));
    }

    private ParticipantKey participantId(Long eventId, Long userId){
        return new ParticipantKey(eventId,userId);
    }
    public void deleteParticipant(Participant participant){
        participantRepository.delete(participant);
    }

    public void saveParticipant(Long eventId, Long userId){
        Participant newParticipant = new Participant(eventService.findEvent(eventId),userService.findUser(userId));
        participantRepository.save(newParticipant);
    }


}
