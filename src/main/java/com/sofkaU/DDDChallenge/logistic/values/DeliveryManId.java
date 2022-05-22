package com.sofkaU.DDDChallenge.logistic.values;

import co.com.sofka.domain.generic.Identity;

public class DeliveryManId extends Identity {
    public DeliveryManId(String uuid) {
        super(uuid);
    }

    public DeliveryManId() {
    }

    public static DeliveryManId of(String id) {
        return new DeliveryManId(id);
    }
}
