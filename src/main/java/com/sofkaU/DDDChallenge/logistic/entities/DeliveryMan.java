package com.sofkaU.DDDChallenge.logistic.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.logistic.values.DeliveryManId;

import java.util.Objects;

public class DeliveryMan extends Entity<DeliveryManId> {

    private Name name;

    public DeliveryMan(DeliveryManId entityId, Name name) {
        super(entityId);
        this.name = name;
    }

    public void UpdateName(Name name) {
        this.name = Objects.requireNonNull(name, "Name can´t be null");
    }

    public Name name() {
        return name;
    }

}
