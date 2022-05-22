package com.sofkaU.DDDChallenge.logistic.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.logistic.values.*;

public class UpdateStoreName extends Command {

    private final LogisticId logisticId;
    private final StoreName storeName;

    public UpdateStoreName(LogisticId logisticId, StoreName storeName) {
        this.logisticId = logisticId;
        this.storeName = storeName;
    }

    public LogisticId getLogisticId() {
        return logisticId;
    }

    public StoreName getStoreName() {
        return storeName;
    }
}
