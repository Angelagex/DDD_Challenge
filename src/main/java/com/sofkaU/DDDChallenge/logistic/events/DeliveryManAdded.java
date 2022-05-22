package com.sofkaU.DDDChallenge.logistic.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.logistic.values.DeliveryManId;

public class DeliveryManAdded extends DomainEvent {
    private final Name name;
    private final YearsOfExperience yearsOfExperience;

    public DeliveryManAdded(DeliveryManId entityId, Name name, YearsOfExperience yearsOfExperience) {
        super("dddchallenge.logistic.deliverymanadded");
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Name getName() {
        return name;
    }

    public YearsOfExperience getYearsOfExperience() {
        return yearsOfExperience;
    }
}
