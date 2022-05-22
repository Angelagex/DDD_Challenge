package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.logistic.values.BodyguardId;

public class BodyguardAdded extends DomainEvent {
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public BodyguardAdded(BodyguardId entityId, Name name, YearsOfExperience yearsOfExperience) {
        super("dddchallenge.logistic.bodymanadded");
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Name getName() {
        return name;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
