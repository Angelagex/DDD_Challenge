package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.logistic.values.BodyguardId;

public class BodyguardNameUpdated extends DomainEvent {

    private final BodyguardId entityId;
    private final Name name;

    public BodyguardNameUpdated(BodyguardId entityId, Name name) {
        super("dddchallenge.logistic.bodyguardnameupdated");
        this.entityId = entityId;
        this.name = name;
    }

    public BodyguardId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
