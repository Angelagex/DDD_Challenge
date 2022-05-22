package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.production.values.ProductionId;

public class CreateProduction extends Command {

    private final ProductionId entityId;
    private final StoreName storeName;

    public CreateProduction(ProductionId entityId, StoreName storeName) {
        this.entityId = entityId;
        this.storeName = storeName;
    }

    public ProductionId getEntityId() {
        return entityId;
    }

    public StoreName getStoreName() {
        return storeName;
    }
}
