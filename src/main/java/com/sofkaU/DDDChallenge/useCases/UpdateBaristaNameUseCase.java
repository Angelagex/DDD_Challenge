package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.production.Production;
import com.sofkaU.DDDChallenge.production.events.BaristaAdded;
import com.sofkaU.DDDChallenge.production.values.ProductionId;

public class UpdateBaristaNameUseCase extends UseCase<TriggeredEvent<BaristaAdded>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<BaristaAdded> baristaAddedTriggeredEvent) {

        var event = baristaAddedTriggeredEvent.getDomainEvent();
        var production = Production.from(ProductionId.of(event.aggregateRootId()),this.retrieveEvents());
        production.AddBarista(event.getEntityId(), event.getName(), event.getYearsOfExperience());
        production.UpdateBaristaName(event.getEntityId(), new Name("Juliancito"));

        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));

    }
}
