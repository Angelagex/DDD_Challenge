package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Brand;
import com.sofkaU.DDDChallenge.production.values.EspressoMachineId;

public class EspressoMachineBrandUpdated extends DomainEvent {

    private final EspressoMachineId entityId;
    private final Brand brand;

    public EspressoMachineBrandUpdated(EspressoMachineId entityId, Brand brand) {
        super("dddchallenge.production.espressomachinebrandupdated");
        this.entityId = entityId;
        this.brand = brand;
    }

    public EspressoMachineId getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }
}
