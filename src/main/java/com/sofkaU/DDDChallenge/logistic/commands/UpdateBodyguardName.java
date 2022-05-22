package com.sofkaU.DDDChallenge.logistic.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.logistic.values.*;

public class UpdateBodyguardName extends Command {

    private final LogisticId logisticId;
    private final BodyguardId entityId;
    private final Name name;


    public UpdateBodyguardName(LogisticId logisticId, BodyguardId entityId, Name name) {
        this.logisticId = logisticId;
        this.entityId = entityId;
        this.name = name;
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
}
