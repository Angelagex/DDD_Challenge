package com.sofkaU.DDDChallenge.logistic;


import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.logistic.entities.*;
import com.sofkaU.DDDChallenge.logistic.events.*;
import com.sofkaU.DDDChallenge.logistic.values.*;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Logistic extends AggregateEvent<LogisticId> {
    protected StoreName storeName;
    protected Set<Bodyguard> bodyguards;
    protected Set<Waiter> waiters;
    protected Set<DeliveryMan> deliverers;


    //Constructors

    public Logistic(LogisticId entityId, StoreName storeName) {
        super(entityId);
        appendChange(new LogisticCreated(storeName)).apply();
    }

    public Logistic(LogisticId logisticId){
        super(logisticId);
        subscribe(new LogisticChange(this));
    }

    public static Logistic from(LogisticId logisticId, List<DomainEvent> events){
        Logistic logistic = new Logistic(logisticId);
        events.forEach(logistic::applyEvent);
        return logistic;
    }

    //Behaviours

    public void UpdateStoreName(StoreName storeName){
        appendChange(new StoreNameUpdated(storeName)).apply();
    }

    public void AddBodyguard(BodyguardId entityId, Name name, YearsOfExperience yearsOfExperience){
        Objects.requireNonNull(entityId,"BodyguardId can't be null");
        Objects.requireNonNull(name, "Name can't be null");
        Objects.requireNonNull(yearsOfExperience, "YearsOfExperience can't be null");
        appendChange(new BodyguardAdded(entityId, name, yearsOfExperience)).apply();
    }

    public void AddWaiter(WaiterId entityId, Name name){
        Objects.requireNonNull(entityId,"WaiterId can't be null");
        Objects.requireNonNull(name, "Name can't be null");
        appendChange(new WaiterAdded(entityId, name)).apply();
    }

    public void AddDeliveryMan(DeliveryManId entityId, Name name){
        Objects.requireNonNull(entityId,"DeliveryManId can't be null");
        Objects.requireNonNull(name, "Name can't be null");
        appendChange(new DeliveryManAdded(entityId, name)).apply();
    }

    public void UpdateBodyguardName(BodyguardId entityId, Name name){
        appendChange(new BodyguardNameUpdated(entityId, name)).apply();
    }

    public void UpdateBodyguardYearsOfExperience(BodyguardId entityId, YearsOfExperience yearsOfExperience){
        appendChange(new BodyguardYearsOfExperienceUpdated(entityId, yearsOfExperience)).apply();
    }

    public void UpdateWaiterName(WaiterId entityId, Name name){
        appendChange(new WaiterNameUpdated(entityId, name)).apply();
    }

    public void UpdateDeliveryManName(DeliveryManId entityId, Name name){
        appendChange(new DeliveryManNameUpdated(entityId, name)).apply();
    }

    //Queries

    public Optional<Bodyguard> getBodyguardById(BodyguardId entityId){
        return bodyguards().stream().filter(m -> m.identity().equals(entityId)).findFirst();
    }

    public Optional<Waiter> getWaiterById(WaiterId entityId){
        return waiters().stream().filter(m -> m.identity().equals(entityId)).findFirst();
    }

    public Optional<DeliveryMan> getDeliveryManById(DeliveryManId entityId){
        return deliverers().stream().filter(m -> m.identity().equals(entityId)).findFirst();
    }

    //Retrievers

    public StoreName storeName() {
        return storeName;
    }

    public Set<Bodyguard> bodyguards() {
        return bodyguards;
    }

    public Set<Waiter> waiters() {
        return waiters;
    }

    public Set<DeliveryMan> deliverers() {
        return deliverers;
    }
}
