package com.sofkaU.DDDChallenge.logistic.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.logistic.values.DeliverryManId;

import java.util.Objects;

public class DeliveryMan extends Entity<DeliverryManId> {

    private Name name;

    public DeliveryMan(DeliverryManId entityId, Name name) {
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
