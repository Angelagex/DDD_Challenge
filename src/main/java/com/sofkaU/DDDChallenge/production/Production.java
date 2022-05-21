package com.sofkaU.DDDChallenge.production;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.production.entities.Barista;
import com.sofkaU.DDDChallenge.production.entities.EspressoMachine;
import com.sofkaU.DDDChallenge.production.entities.Mixer;
import com.sofkaU.DDDChallenge.production.events.ProductionCreated;
import com.sofkaU.DDDChallenge.production.values.ProductionId;

import java.util.Set;

public class Production extends AggregateEvent<ProductionId> {

    protected StoreName storeName;
    protected Set<EspressoMachine> espressoMachines;
    protected Set<Barista> baristas;
    protected Set<Mixer> mixers;

    public Production(ProductionId entityId, StoreName storeName) {
        super(entityId);
        appendChange(new ProductionCreated(storeName)).apply();
    }
}
