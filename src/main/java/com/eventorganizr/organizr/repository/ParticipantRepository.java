package com.eventorganizr.organizr.repository;

import com.eventorganizr.organizr.entity.Event;
import com.eventorganizr.organizr.entity.compositeKeys.ParticipantKey;
import com.eventorganizr.organizr.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant,Long> {
    List<Participant> findAllByEventEventId(Long eventId);
    List<Participant> findAllByUserUserId(Long userId);
    void delete(Participant participant);
    Participant findByEvent_EventIdAndUser_UserId(Long event_eventId, Long user_userId);
    Participant findByParticipantId(ParticipantKey participantId);
    void deleteByParticipantId(ParticipantKey participantId);
    void deleteByEvent(Event event);

}
