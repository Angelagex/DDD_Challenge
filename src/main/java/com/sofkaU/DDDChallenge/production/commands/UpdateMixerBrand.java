package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.values.*;

public class UpdateMixerBrand extends Command {
    private final ProductionId productionId;
    private final MixerId entityId;
    private final Brand brand;

    public UpdateMixerBrand(ProductionId productionId, MixerId entityId, Brand brand) {
        this.productionId = productionId;
        this.entityId = entityId;
        this.brand = brand;
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
}
