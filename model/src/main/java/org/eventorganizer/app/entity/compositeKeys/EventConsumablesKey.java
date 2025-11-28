package org.eventorganizer.app.entity.compositeKeys;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

public record EventConsumablesKey(@NotNull Long eventId, @NotNull Long consumableId) implements Serializable {

    public EventConsumablesKey(Long eventId, Long consumableId) {
        this.eventId = eventId;
        this.consumableId = consumableId;
    }


}
