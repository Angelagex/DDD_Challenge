package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.logistic.values.DeliveryManId;

public class DeliveryManAdded extends DomainEvent {
    private final DeliveryManId entityId;
    private final Name name;

    public DeliveryManAdded(DeliveryManId entityId, Name name) {
        super("dddchallenge.logistic.deliverymanadded");
        this.entityId = entityId;
        this.name = name;
    }

    public DeliveryManId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

}
