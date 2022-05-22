package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;

public class StoreNameUpdated extends DomainEvent {

    private final StoreName storeName;

    public StoreNameUpdated(StoreName storeName) {
        super("dddchallenge.logistic.storenameupdated");
        this.storeName = storeName;
    }

    public StoreName getStoreName() {
        return storeName;
    }

}
