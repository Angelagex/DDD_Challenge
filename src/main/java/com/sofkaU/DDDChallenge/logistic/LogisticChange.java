package com.sofkaU.DDDChallenge.logistic;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.DDDChallenge.logistic.entities.Bodyguard;
import com.sofkaU.DDDChallenge.logistic.entities.DeliveryMan;
import com.sofkaU.DDDChallenge.logistic.entities.Waiter;
import com.sofkaU.DDDChallenge.logistic.events.*;

import java.util.HashSet;

public class LogisticChange extends EventChange {
    public LogisticChange(Logistic logistic) {

        apply((LogisticCreated event) -> {
            logistic.storeName = event.getStoreName();
            logistic.bodyguards = new HashSet<>();
            logistic.waiters = new HashSet<>();
            logistic.deliverers = new HashSet<>();
        });

        apply((StoreNameUpdated event) -> {
            logistic.storeName = event.getStoreName();
        });

        apply((BodyguardAdded event) -> {
            var nBodyguard = logistic.bodyguards().size();
            if (nBodyguard >= 2) {
                throw new IllegalArgumentException("You can only have 2 Bodyguards");
            }
            logistic.bodyguards.add(new Bodyguard(
                    event.getEntityId(),
                    event.getName(),
                    event.getYearsOfExperience()
            ));
        });

        apply((BodyguardNameUpdated event) -> {
            var bodyguard = logistic.getBodyguardById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Bodyguard can't be found"));
            bodyguard.UpdateName(event.getName());
        });

        apply((BodyguardYearsOfExperienceUpdated event) -> {
            var bodyguard = logistic.getBodyguardById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Bodyguard can't be found"));
            bodyguard.UpdateYearsOfExperience(event.getYearsOfExperience());
        });

        apply((DeliveryManAdded event) -> {
            var delivery = logistic.deliverers().size();
            if (delivery >= 3) {
                throw new IllegalArgumentException("You can only have 3 Deliverers");
            }
            logistic.deliverers.add(new DeliveryMan(
                    event.getEntityId(),
                    event.getName()
            ));
        });

        apply((DeliveryManNameUpdated event) -> {
            var delivery = logistic.getDeliveryManById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("DeliveryMan can't be found"));
            delivery.UpdateName(event.getName());
        });

        apply((WaiterAdded event) -> {
            var waiter = logistic.waiters().size();
            if (waiter >= 4) {
                throw new IllegalArgumentException("You can only have 4 Waiters");
            }
            logistic.waiters.add(new Waiter(
                    event.getEntityId(),
                    event.getName()
            ));
        });

        apply((WaiterNameUpdated event) -> {
            var waiter = logistic.getWaiterById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Waiter can't be found"));
            waiter.UpdateName(event.getName());
        });
    }
}
