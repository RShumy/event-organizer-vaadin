package org.eventorganizer.app.entity.compositeKeys;

import org.hibernate.annotations.Columns;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ParticipantConsumablesKey implements Serializable {

    @Column(name = "consumable_id")
    private Long consumableId;

    @Columns(columns = {
            @Column(name = "user_id"),
            @Column(name = "event_id")
    })
    private ParticipantKey participantId;

    public ParticipantConsumablesKey(){}
    public ParticipantConsumablesKey(Long consumableId, ParticipantKey participantId) {
        this.consumableId = consumableId;
        this.participantId = participantId;
    }
    public ParticipantConsumablesKey(Long consumableId, Long eventId, Long userId){
        this.consumableId = consumableId;
        this.participantId = new ParticipantKey(eventId,userId);
    }
}
