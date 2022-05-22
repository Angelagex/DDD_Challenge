package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.production.events.ProductionCreated;
import com.sofkaU.DDDChallenge.production.events.StoreNameUpdated;
import com.sofkaU.DDDChallenge.useCases.UpdateProductionStoreNameUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
public class UpdateProductionStoreNameUseCaseTest {


    private final String RootId = "123";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateStoreNameTest(){

        var event = new ProductionCreated(
                new StoreName("Store1")
        );
        event.setAggregateRootId(RootId);

        var useCase = new UpdateProductionStoreNameUseCase();

        Mockito.when(repository.getEventsBy(RootId)).thenReturn(List.of(
                event
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(RootId)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong updating the Production Store Name"))
                .getDomainEvents();

        var storeNameInProduction = (StoreNameUpdated) events.get(0);
        Assertions.assertEquals("TheStore_2.0", storeNameInProduction.getStoreName().value());
        Mockito.verify(repository).getEventsBy(RootId);
    }
}
