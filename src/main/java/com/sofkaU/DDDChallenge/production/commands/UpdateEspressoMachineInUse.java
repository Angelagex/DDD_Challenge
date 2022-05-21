package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.values.*;

public class UpdateEspressoMachineInUse extends Command {
    private final ProductionId productionId;
    private final EspressoMachineId entityId;
    private final InUse inUse;

    public UpdateEspressoMachineInUse(ProductionId productionId, EspressoMachineId entityId, InUse inUse) {
        this.productionId = productionId;
        this.entityId = entityId;
        this.inUse = inUse;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public EspressoMachineId getEntityId() {
        return entityId;
    }

    public InUse getInUse() {
        return inUse;
    }
}
