package com.eventorganizr.organizr.entity;

import com.eventorganizr.organizr.entity.compositeKeys.ParticipantConsumablesKey;
import com.eventorganizr.organizr.entity.compositeKeys.ParticipantKey;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "participant_consumables")
public class ParticipantConsumable {

    @EmbeddedId
    private ParticipantConsumablesKey ParticipantConsumablesId;


    @ManyToOne
    @MapsId("participantId")
    @JoinColumns({
            @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = true, updatable = true),
            @JoinColumn(name = "event_id",referencedColumnName = "event_id" ,insertable = true, updatable = true)
    })
    @JsonBackReference
    private Participant participant;

    @ManyToOne
    @MapsId("consumableId")
    @JoinColumn(name = "consumable_id")
    @JsonBackReference
    private Consumable consumable;

    public ParticipantConsumable(ParticipantConsumablesKey participantConsumablesId, Participant participant, Consumable consumable) {
        ParticipantConsumablesId = participantConsumablesId;
        this.participant = participant;
        this.consumable = consumable;
    }

    public ParticipantConsumable(Participant participant, Consumable consumable){
        ParticipantConsumablesId = new ParticipantConsumablesKey(consumable.getConsumableId(), participant.getParticipantId());
        this.participant = participant;
        this.consumable = consumable;
    }

    public ParticipantConsumable() {}

    public ParticipantConsumablesKey getParticipantConsumablesId() {
        return ParticipantConsumablesId;
    }

    public void setParticipantConsumablesId(ParticipantConsumablesKey participantConsumablesId) {
        ParticipantConsumablesId = participantConsumablesId;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }

}
