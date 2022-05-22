package com.sofkaU.DDDChallenge.logistic.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.logistic.values.*;

public class UpdateBodyguardYearsOfExperience extends Command {

    private final LogisticId logisticId;
    private final BodyguardId entityId;
    private final YearsOfExperience yearsOfExperience;

    public UpdateBodyguardYearsOfExperience(LogisticId logisticId, BodyguardId entityId, YearsOfExperience yearsOfExperience) {
        this.logisticId = logisticId;
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }


    public LogisticId getLogisticId() {
        return logisticId;
    }

    public BodyguardId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
