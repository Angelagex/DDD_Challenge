package com.sofkaU.DDDChallenge.production.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.values.*;

public class UpdateStoreName extends Command {
    private final ProductionId productionId;
    private final StoreName storeName;

    public UpdateStoreName(ProductionId productionId, StoreName storeName) {
        this.productionId = productionId;
        this.storeName = storeName;
    }

    public ProductionId getProductionId() {
        return productionId;
    }

    public StoreName getStoreName() {
        return storeName;
    }
}
