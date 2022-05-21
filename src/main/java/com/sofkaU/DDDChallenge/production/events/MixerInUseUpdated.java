package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.InUse;
import com.sofkaU.DDDChallenge.production.values.MixerId;

public class MixerInUseUpdated extends DomainEvent {

    private final MixerId entityId;
    private final InUse inUse;

    public MixerInUseUpdated(MixerId entityId, InUse inUse) {
        super("dddchallenge.production.mixerinuseupdated");
        this.entityId = entityId;
        this.inUse = inUse;
    }

    public MixerId getEntityId() {
        return entityId;
    }

    public InUse getInUse() {
        return inUse;
    }
}
