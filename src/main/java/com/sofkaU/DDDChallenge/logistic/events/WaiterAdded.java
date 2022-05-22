package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.logistic.values.WaiterId;

public class WaiterAdded extends DomainEvent {

    private final WaiterId entityId;
    private final Name name;

    public WaiterAdded(WaiterId entityId, Name name) {
        super("dddchallenge.logistic.waiteradded");
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
