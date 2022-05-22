package com.sofkaU.DDDChallenge.logistic;


import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.logistic.entities.*;
import com.sofkaU.DDDChallenge.logistic.values.*;

import java.util.Set;

public class Logistic extends AggregateEvent<LogisticId> {
    protected StoreName storeName;
    protected Set<Bodyguard> bodyguards;
    protected Set<Waiter> waiters;
    protected Set<DeliveryMan> deliverers;


    public Logistic(LogisticId entityId) {
        super(entityId);
    }

}
