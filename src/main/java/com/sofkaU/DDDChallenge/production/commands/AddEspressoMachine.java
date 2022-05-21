package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.values.*;

public class AddEspressoMachine extends Command {
    private final ProductionId productionId;
    private final EspressoMachineId entityId;
    private final Brand brand;
    private final InUse inUse;

    public AddEspressoMachine(ProductionId productionId, EspressoMachineId entityId, Brand brand, InUse inUse) {
        this.productionId = productionId;
        this.entityId = entityId;
        this.brand = brand;
        this.inUse = inUse;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public EspressoMachineId getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }

    public InUse getInUse() {
        return inUse;
    }
}
