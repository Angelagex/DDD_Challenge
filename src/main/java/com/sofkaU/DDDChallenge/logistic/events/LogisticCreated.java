package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;

public class LogisticCreated extends DomainEvent {

    private final StoreName storeName;

    public LogisticCreated(StoreName storeName) {
        super("dddchallenge.production.logisticcreated");
        this.storeName = storeName;
    }

    public StoreName getStoreName() {
        return storeName;
    }
}
