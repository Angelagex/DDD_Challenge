package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.values.*;

public class AddBarista extends Command {
    private final ProductionId productionId;
    private final BaristaId entityId;
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public AddBarista(ProductionId productionId, BaristaId entityId, Name name, YearsOfExperience yearsOfExperience) {
        this.productionId = productionId;
        this.entityId = entityId;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
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

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
