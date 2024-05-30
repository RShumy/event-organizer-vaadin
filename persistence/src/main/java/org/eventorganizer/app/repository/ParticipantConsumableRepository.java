package org.eventorganizer.app.repository;

import org.eventorganizer.app.entity.Participant;
import org.eventorganizer.app.entity.ParticipantConsumable;
import org.eventorganizer.app.entity.compositeKeys.ParticipantConsumablesKey;
import org.eventorganizer.app.entity.compositeKeys.ParticipantKey;
import org.eventorganizer.app.entity.compositeKeys.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantConsumableRepository extends JpaRepository<ParticipantConsumable, Long> {

    List<ParticipantConsumable> findByParticipant(Participant participant);

    List<ParticipantConsumable> findByParticipant_ParticipantId(ParticipantKey participant_participantId);

    List<ParticipantConsumable> findByParticipantAndConsumable_ConsumableType(Participant participant, String consumable_consumableType);

    void deleteParticipantConsumableByParticipantConsumablesId(ParticipantConsumablesKey participantConsumablesKey);

    void deleteAllByParticipant_ParticipantId(ParticipantKey participant_participantId);

    void deleteAllByParticipant_Event_EventIdAndConsumable_ConsumableType(Long participant_event_eventId, String consumable_consumableType);
}
