package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Brand;
import com.sofkaU.DDDChallenge.generic.values.InUse;
import com.sofkaU.DDDChallenge.production.values.MixerId;

public class MixerAdded extends DomainEvent {

    private final MixerId entityId;
    private final Brand brand;
    private final InUse inUse;

    public MixerAdded(MixerId entityId, Brand brand, InUse inUse) {
        super("dddchallenge.production.mixeradded");
        this.entityId = entityId;
        this.brand = brand;
        this.inUse = inUse;
    }

    public MixerId getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }

    public InUse getInUse() {
        return inUse;
    }
}
