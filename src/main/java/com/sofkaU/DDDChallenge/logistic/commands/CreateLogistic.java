package com.sofkaU.DDDChallenge.logistic.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.logistic.values.LogisticId;

public class CreateLogistic extends Command {

    private final LogisticId entityId;
    private final StoreName storeName;

    public CreateLogistic(LogisticId entityId, StoreName storeName) {
        this.entityId = entityId;
        this.storeName = storeName;
    }

    public LogisticId getEntityId() {
        return entityId;
    }

    public StoreName getStoreName() {
        return storeName;
    }
}
