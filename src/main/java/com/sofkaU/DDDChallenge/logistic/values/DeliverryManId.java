package com.sofkaU.DDDChallenge.logistic.values;

import co.com.sofka.domain.generic.Identity;

public class DeliverryManId extends Identity {
    public DeliverryManId(String uuid) {
        super(uuid);
    }

    public DeliverryManId() {
    }

    public static DeliverryManId of(String id) {
        return new DeliverryManId(id);
    }
}
