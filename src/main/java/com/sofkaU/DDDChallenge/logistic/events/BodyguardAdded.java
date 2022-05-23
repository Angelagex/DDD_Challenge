package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.logistic.values.BodyguardId;

public class BodyguardAdded extends DomainEvent {

    private final BodyguardId entityId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public BodyguardAdded(BodyguardId entityId, Name name, YearsOfExperience yearsOfExperience) {
        super("dddchallenge.logistic.bodyguardadded");
        this.entityId = entityId;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public BodyguardId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
