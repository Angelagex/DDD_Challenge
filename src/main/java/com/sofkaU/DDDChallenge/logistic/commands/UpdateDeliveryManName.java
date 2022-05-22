package com.sofkaU.DDDChallenge.logistic.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.logistic.values.*;

public class UpdateDeliveryManName extends Command {

    private final LogisticId logisticId;
    private final DeliveryManId entityId;
    private final Name name;

    public UpdateDeliveryManName(LogisticId logisticId, DeliveryManId entityId, Name name) {
        this.logisticId = logisticId;
        this.entityId = entityId;
        this.name = name;
    }

    public LogisticId getLogisticId() {
        return logisticId;
    }

    public DeliveryManId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
