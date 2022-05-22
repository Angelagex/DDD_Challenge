package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.production.Production;
import com.sofkaU.DDDChallenge.production.events.ProductionCreated;
import com.sofkaU.DDDChallenge.production.values.ProductionId;

public class UpdateProductionStoreNameUseCase extends UseCase<TriggeredEvent<ProductionCreated>, ResponseEvents> {

    @Override
    public void executeUseCase(TriggeredEvent<ProductionCreated> productionCreatedTriggeredEvent) {

        var event = productionCreatedTriggeredEvent.getDomainEvent();
        var production = Production.from(ProductionId.of(event.aggregateRootId()),this.retrieveEvents());
        production.UpdateStoreName(new StoreName("TheStore_2.0"));

        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));

    }
}
