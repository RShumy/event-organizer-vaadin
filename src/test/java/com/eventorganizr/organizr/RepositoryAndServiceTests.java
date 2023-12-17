package com.eventorganizr.organizr;

import com.eventorganizr.organizr.entity.Authority;
import com.eventorganizr.organizr.entity.Event;
import com.eventorganizr.organizr.entity.Participant;
import com.eventorganizr.organizr.entity.User;
import com.eventorganizr.organizr.repository.*;
import com.eventorganizr.organizr.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RepositoryAndServiceTests {

    //Tests instantiating actual Repository classes
    //This is not an indicated practice or in a professional setting
    //I hear that this is ok as long as the application is small
    //I will have to refine the tests

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    ConsumableRepository consumableRepository;

    @Autowired
    ParticipantConsumableRepository participantConsumableRepository;

    @Autowired
    AuthorityService authorityService;

    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    @Autowired
    ParticipantService participantService;

    @Autowired
    ConsumableService consumableService;

    @Autowired
    ParticipantConsumableService participantConsumableService;


    //Testing JPA Hibernate annotations
//    ----------------------------------------------------
    @Test
    public void serviceDeletingUserShouldAlsoDeleteParticipantWithUserId(){

        User user = userService.findUserByUserName("least0");
        List<Participant> participants = participantService.findParticipantsByUserId(user.getUserId());
        System.out.println("Participants before delition" + participants);
        userService.delete(user.getUserId());
        Assertions.assertTrue(participantService.findParticipantsByUserId(user.getUserId()).isEmpty());

    }

    @Autowired
    CommandLineRunner clr;

    @Before
    public void runCLRandInitializeData(){
        try {
            this.clr = InitCLR.initialize(authorityService,userService,eventService,participantService,consumableService);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void serviceDeletingUserShouldNotDeleteEventsConnectedThroughParticipant(){
        User user = userService.findUserByUserName("svennings1");
        System.out.println("From Test ----- User found ---- " + user.getUserId());
        participantService.saveParticipant(1L ,user.getUserId());
        List<Event> eventsWhereUserIsParticipant = participantService.getEventsForUser(user.getUserId()).isEmpty() ? new ArrayList<Event>() : participantService.getEventsForUser(user.getUserId());

        System.out.println("Events Where User Is Participant" + eventsWhereUserIsParticipant);
        userService.delete(user.getUserId());
        eventsWhereUserIsParticipant.forEach( (e)-> {
                System.out.println(eventService.findEvent(e.getEventId()));
                Assertions.assertTrue(Optional.of(eventService.findEvent(e.getEventId())).isPresent());}
        );
    }

}
