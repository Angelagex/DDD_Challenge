package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.production.values.BaristaId;

public class BaristaNameUpdated extends DomainEvent {

    private final BaristaId entityId;
    private final Name name;

    public BaristaNameUpdated(BaristaId entityId, Name name) {
        super("dddchallenge.production.baristanameupdated");
        this.entityId = entityId;
        this.name = name;
    }

    public BaristaId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
