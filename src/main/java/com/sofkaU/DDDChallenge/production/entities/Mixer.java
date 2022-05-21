package com.sofkaU.DDDChallenge.production.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.DDDChallenge.production.values.MixerId;

public class Mixer extends Entity<MixerId> {
    public Mixer(MixerId entityId) {
        super(entityId);
    }
}
