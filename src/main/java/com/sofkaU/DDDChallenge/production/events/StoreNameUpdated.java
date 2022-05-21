package com.sofkaU.DDDChallenge.production.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;

public class StoreNameUpdated extends DomainEvent {

    private final StoreName storeName;

    public StoreNameUpdated(StoreName storeName) {
        super("dddchallenge.production.storenameupdated");
        this.storeName = storeName;
    }

    public StoreName getStoreName() {
        return storeName;
    }

}
