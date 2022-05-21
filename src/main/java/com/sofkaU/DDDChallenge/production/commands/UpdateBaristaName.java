package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.values.*;

public class UpdateBaristaName extends Command {
    private final ProductionId productionId;
    private final BaristaId entityId;
    private final Name name;

    public UpdateBaristaName(ProductionId productionId, BaristaId entityId, Name name) {
        this.productionId = productionId;
        this.entityId = entityId;
        this.name = name;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public BaristaId getEntityId() {
        return entityId;
    }

    public Name getName() {
        return name;
    }
}
