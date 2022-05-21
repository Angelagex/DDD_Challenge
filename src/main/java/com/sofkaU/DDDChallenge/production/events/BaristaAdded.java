package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.production.values.BaristaId;

public class BaristaAdded extends DomainEvent {

    private final BaristaId entityId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public BaristaAdded(BaristaId entityId, Name name, YearsOfExperience yearsOfExperience) {
        super("dddchallenge.production.baristaadded");
        this.entityId = entityId;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public BaristaId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
