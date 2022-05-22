package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.logistic.Logistic;
import com.sofkaU.DDDChallenge.logistic.events.LogisticCreated;
import com.sofkaU.DDDChallenge.logistic.values.LogisticId;

public class UpdateLogisticStoreNameUseCase extends UseCase<TriggeredEvent<LogisticCreated>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<LogisticCreated> logisticCreatedTriggeredEvent) {
        var event = logisticCreatedTriggeredEvent.getDomainEvent();
        var logistic = Logistic.from(LogisticId.of(event.aggregateRootId()),this.retrieveEvents());
        logistic.UpdateStoreName(new StoreName("TheBestStoreEver"));

        emit().onResponse(new ResponseEvents(logistic.getUncommittedChanges()));
    }
}
