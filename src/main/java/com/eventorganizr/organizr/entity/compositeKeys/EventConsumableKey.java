package com.eventorganizr.organizr.entity.compositeKeys;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public record EventConsumableKey(@NotNull Long eventId, @NotNull Long consumableId) implements Serializable {

    public EventConsumableKey(Long eventId, Long consumableId) {
        this.eventId = eventId;
        this.consumableId = consumableId;
    }


}
