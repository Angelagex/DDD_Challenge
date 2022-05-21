package com.sofkaU.DDDChallenge.production;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.DDDChallenge.production.events.ProductionCreated;

import java.util.HashSet;

public class ProductionChange extends EventChange {
    public ProductionChange(Production production) {
        apply( (ProductionCreated event) -> {
            production.storeName = event.getStoreName();
            production.espressoMachines = new HashSet<>();
            production.baristas = new HashSet<>();
            production.mixers = new HashSet<>();
        });
    }
}
