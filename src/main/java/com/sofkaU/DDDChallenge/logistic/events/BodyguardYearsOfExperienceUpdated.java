package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.logistic.values.BodyguardId;

public class BodyguardYearsOfExperienceUpdated extends DomainEvent {
    private final BodyguardId entityId;
    private final YearsOfExperience yearsOfExperience;

    public BodyguardYearsOfExperienceUpdated(BodyguardId entityId, YearsOfExperience yearsOfExperience) {
        super("dddchallenge.logistic.bodyguardyearsofexperienceupdated");
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public BodyguardId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
