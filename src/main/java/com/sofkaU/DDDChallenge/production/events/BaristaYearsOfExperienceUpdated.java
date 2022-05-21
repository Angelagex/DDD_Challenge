package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.production.values.BaristaId;

public class BaristaYearsOfExperienceUpdated extends DomainEvent {

    private final BaristaId entityId;
    private final YearsOfExperience yearsOfExperience;

    public BaristaYearsOfExperienceUpdated(BaristaId entityId, YearsOfExperience yearsOfExperience) {
        super("dddchallenge.production.baristayearsofexperienceupdated");
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public BaristaId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
