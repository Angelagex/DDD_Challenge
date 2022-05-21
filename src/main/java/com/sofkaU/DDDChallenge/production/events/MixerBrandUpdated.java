package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Brand;
import com.sofkaU.DDDChallenge.production.values.MixerId;

public class MixerBrandUpdated extends DomainEvent {

    private final MixerId entityId;
    private final Brand brand;

    public MixerBrandUpdated(MixerId entityId, Brand brand) {
        super("dddchallenge.production.mixerbrandupdated");
        this.entityId = entityId;
        this.brand = brand;
    }

    public MixerId getEntityId() {
        return entityId;
    }

    public Brand getBrand() {
        return brand;
    }
}
