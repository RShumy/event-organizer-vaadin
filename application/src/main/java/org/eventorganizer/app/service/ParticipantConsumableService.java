package org.eventorganizer.app.service;

import org.eventorganizer.app.entity.Consumable;
import org.eventorganizer.app.entity.Participant;
import org.eventorganizer.app.entity.ParticipantConsumable;
import org.eventorganizer.app.entity.compositeKeys.ParticipantConsumablesKey;
import org.eventorganizer.app.repository.ParticipantConsumableRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantConsumableService {

    private final ParticipantConsumableRepository participantConsumableRepository;

    private final ParticipantService participantService;

    private final ConsumableService consumableService;

    public ParticipantConsumableService(ParticipantConsumableRepository participantConsumableRepository, ParticipantService participantService, ConsumableService consumableService) {
        this.participantConsumableRepository = participantConsumableRepository;
        this.participantService = participantService;
        this.consumableService = consumableService;
    }

    public List<Consumable> getConsumablesForParticipant(Participant participant){
        return participantConsumableRepository.findByParticipant(participant).stream().map(ParticipantConsumable::getConsumable).toList();
    }

    public void addConsumableToParticipant(Consumable consumable, Participant participant){
        participantService.findParticipantById(participant.getParticipantId());
    }

    public void removeConsumableForParticipant(Consumable consumable, Participant participant){
        ParticipantConsumablesKey key = new ParticipantConsumablesKey(consumable.getConsumableId(), participant.getParticipantId());
        participantConsumableRepository.deleteParticipantConsumableByParticipantConsumablesId(key);
    }

}
