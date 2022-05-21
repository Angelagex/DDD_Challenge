package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.InUse;
import com.sofkaU.DDDChallenge.production.values.EspressoMachineId;

public class EspressoMachineInUseUpdated extends DomainEvent {

    private final EspressoMachineId entityId;
    private final InUse inUse;

    public EspressoMachineInUseUpdated(EspressoMachineId entityId, InUse inUse) {
        super("dddchallenge.production.espressomachineinuseupdated");
        this.entityId = entityId;
        this.inUse = inUse;
    }

    public EspressoMachineId getEntityId() {
        return entityId;
    }

    public InUse getInUse() {
        return inUse;
    }
}
