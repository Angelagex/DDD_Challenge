package com.sofkaU.DDDChallenge.production;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.production.entities.Barista;
import com.sofkaU.DDDChallenge.production.entities.EspressoMachine;
import com.sofkaU.DDDChallenge.production.entities.Mixer;
import com.sofkaU.DDDChallenge.production.events.ProductionCreated;
import com.sofkaU.DDDChallenge.production.values.ProductionId;

import java.util.List;
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

    public Production(ProductionId productionId){
        super(productionId);
        subscribe(new ProductionChange(this));
    }

    public static Production from(ProductionId productionId, List<DomainEvent> events){
        Production production = new Production(productionId);
        events.forEach(production::applyEvent);
        return production;
    }

    public StoreName storeName() {
        return storeName;
    }

    public Set<EspressoMachine> espressoMachines() {
        return espressoMachines;
    }

    public Set<Barista> baristas() {
        return baristas;
    }

    public Set<Mixer> mixers() {
        return mixers;
    }
}
