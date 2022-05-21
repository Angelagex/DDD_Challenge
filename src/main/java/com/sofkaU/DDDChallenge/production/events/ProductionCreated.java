package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;

public class ProductionCreated extends DomainEvent {
    private StoreName storeName;

    public ProductionCreated(StoreName storeName) {
        super("dddchallenge.production.productioncreated");
        this.storeName = storeName;
    }

    public StoreName getStoreName() {
        return storeName;
    }
}

