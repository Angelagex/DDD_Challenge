package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Brand;
import com.sofkaU.DDDChallenge.generic.values.InUse;
import com.sofkaU.DDDChallenge.production.values.EspressoMachineId;

public class EspressoMachineAdded extends DomainEvent {

    private final EspressoMachineId entityId;
    private final Brand brand;
    private final InUse inUse;

    public EspressoMachineAdded(EspressoMachineId entityId, Brand brand, InUse inUse) {
        super("dddchallenge.production.espressomachineadded");
        this.entityId = entityId;
        this.brand = brand;
        this.inUse = inUse;
    }

    public EspressoMachineId getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }

    public InUse getInUse() {
        return inUse;
    }
}
