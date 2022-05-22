package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.logistic.values.WaiterId;

public class WaiterNameUpdated extends DomainEvent {

    private final WaiterId entityId;
    private final Name name;

    public WaiterNameUpdated(WaiterId entityId, Name name) {
        super("dddchallenge.logistic.waiternameupdated");
        this.entityId = entityId;
        this.name = name;
    }

    public WaiterId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
