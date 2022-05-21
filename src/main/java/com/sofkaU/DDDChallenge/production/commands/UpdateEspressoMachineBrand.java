package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.values.*;

public class UpdateEspressoMachineBrand extends Command {
    private final ProductionId productionId;
    private final EspressoMachineId entityId;
    private final Brand brand;

    public UpdateEspressoMachineBrand(ProductionId productionId, EspressoMachineId entityId, Brand brand) {
        this.productionId = productionId;
        this.entityId = entityId;
        this.brand = brand;
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
}
