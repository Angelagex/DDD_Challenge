package com.sofkaU.DDDChallenge.production.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.DDDChallenge.production.values.BaristaId;

public class Barista extends Entity<BaristaId> {
    public Barista(BaristaId entityId) {
        super(entityId);
    }
}
