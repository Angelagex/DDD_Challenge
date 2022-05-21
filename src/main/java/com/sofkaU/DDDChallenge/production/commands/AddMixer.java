package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.values.*;

public class AddMixer extends Command {
    private final ProductionId productionId;
    private final MixerId entityId;
    private final Brand brand;
    private final InUse inUse;

    public AddMixer(ProductionId productionId, MixerId entityId, Brand brand, InUse inUse) {
        this.productionId = productionId;
        this.entityId = entityId;
        this.brand = brand;
        this.inUse = inUse;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public MixerId getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }

    public InUse getInUse() {
        return inUse;
    }
}
