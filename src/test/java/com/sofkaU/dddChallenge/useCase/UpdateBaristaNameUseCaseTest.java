package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.production.commands.UpdateBaristaName;
import com.sofkaU.DDDChallenge.production.events.BaristaNameUpdated;
import com.sofkaU.DDDChallenge.production.events.ProductionCreated;
import com.sofkaU.DDDChallenge.production.values.BaristaId;
import com.sofkaU.DDDChallenge.production.values.ProductionId;
import com.sofkaU.DDDChallenge.useCases.UpdateBaristaNameUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UpdateBaristaNameUseCaseTest {

    private final String RootId = "123";

    @Mock
    private DomainEventRepository repository;

    @Test
    void updateBaristaNameTest(){

        var command = new UpdateBaristaName(ProductionId.of(RootId), BaristaId.of("dddd"), new Name("José Angel"));
        var useCase = new UpdateBaristaNameUseCase();

        Mockito.when(repository.getEventsBy(RootId)).thenReturn(List.of(
                new ProductionCreated(
                        new StoreName("littleStore")
                )
        ));


        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(RootId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding a Barista"))
                .getDomainEvents();

        var event = (BaristaNameUpdated) events.get(1);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getEntityId().value(), event.getEntityId().value());
    }

}


