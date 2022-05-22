package com.sofkaU.DDDChallenge.logistic.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.logistic.values.*;

public class AddWaiter extends Command {

    private final LogisticId logisticId;
    private final WaiterId entityId;
    private final Name name;

    public AddWaiter(LogisticId logisticId, WaiterId entityId, Name name) {
        this.logisticId = logisticId;
        this.entityId = entityId;
        this.name = name;
    }

    public LogisticId getLogisticId() {
        return logisticId;
    }

    public WaiterId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
