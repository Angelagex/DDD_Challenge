package com.sofkaU.DDDChallenge.logistic.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.logistic.values.*;

public class AddBodyguard extends Command {

    private final LogisticId logisticId;
    private final BodyguardId entityId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public AddBodyguard(LogisticId logisticId, BodyguardId entityId, Name name, YearsOfExperience yearsOfExperience) {
        this.logisticId = logisticId;
        this.entityId = entityId;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public LogisticId getLogisticId() {
        return logisticId;
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
