package org.eventorganizer.app.repository;

import org.eventorganizer.app.entity.Event;
import org.eventorganizer.app.entity.Participant;
import org.eventorganizer.app.entity.compositeKeys.ParticipantKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
