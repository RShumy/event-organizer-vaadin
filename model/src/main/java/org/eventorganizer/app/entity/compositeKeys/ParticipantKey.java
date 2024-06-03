package org.eventorganizer.app.entity.compositeKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

//Used to Create Lookup table
@Embeddable
public class ParticipantKey implements Serializable {
    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "user_id")
    private Long userId;

    public ParticipantKey(Long eventId, Long userId) {
        this.eventId = eventId;
        this.userId = userId;
    }

    public ParticipantKey() {
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventID) {
        this.eventId = eventID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userID) {
        this.userId = userID;
    }

    @Override
    public String toString() {
        return "ParticipantKey{" +
                "eventId=" + eventId +
                ", userId=" + userId +
                '}';
    }
}
