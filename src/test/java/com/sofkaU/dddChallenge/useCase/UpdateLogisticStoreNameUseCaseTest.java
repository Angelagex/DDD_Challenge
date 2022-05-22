package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.logistic.events.LogisticCreated;
import com.sofkaU.DDDChallenge.logistic.events.StoreNameUpdated;
import com.sofkaU.DDDChallenge.useCases.UpdateLogisticStoreNameUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;


@ExtendWith(MockitoExtension.class)
class UpdateLogisticStoreNameUseCaseTest {


    @Mock
    private DomainEventRepository repository;

    @Test
    void updateLogisticStoreNameTest(){

        var event = new LogisticCreated(
                new StoreName("StoreNameTest")
        );
        String rootId = "Store999";
        event.setAggregateRootId(rootId);

        var useCase = new UpdateLogisticStoreNameUseCase();

        Mockito.when(repository.getEventsBy(rootId)).thenReturn(List.of(
                event
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(rootId)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong updating the Logistic Store Name"))
                .getDomainEvents();

        var storeNameInLogistic = (StoreNameUpdated) events.get(0);
        Assertions.assertEquals("TheBestStoreEver", storeNameInLogistic.getStoreName().value());
        Mockito.verify(repository).getEventsBy(rootId);
    }

}
