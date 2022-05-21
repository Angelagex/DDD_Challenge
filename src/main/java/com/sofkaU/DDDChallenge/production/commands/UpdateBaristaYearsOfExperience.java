package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.values.*;

public class UpdateBaristaYearsOfExperience extends Command {
    private final ProductionId productionId;
    private final BaristaId entityId;
    private final YearsOfExperience yearsOfExperience;

    public UpdateBaristaYearsOfExperience(ProductionId productionId, BaristaId entityId, YearsOfExperience yearsOfExperience) {
        this.productionId = productionId;
        this.entityId = entityId;
        this.yearsOfExperience = yearsOfExperience;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public BaristaId getEntityId() {
        return entityId;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
