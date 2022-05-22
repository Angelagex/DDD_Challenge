package com.sofkaU.dddChallenge.useCase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.commands.AddMixer;
import com.sofkaU.DDDChallenge.production.events.BaristaAdded;
import com.sofkaU.DDDChallenge.production.events.MixerAdded;
import com.sofkaU.DDDChallenge.production.events.ProductionCreated;
import com.sofkaU.DDDChallenge.production.values.BaristaId;
import com.sofkaU.DDDChallenge.production.values.MixerId;
import com.sofkaU.DDDChallenge.production.values.ProductionId;
import com.sofkaU.DDDChallenge.useCases.AddMixerUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddMixerUseCaseTest {

    private final String RootId = "321";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addMixer(){

        var command = new AddMixer(ProductionId.of(RootId), MixerId.of("Id1"), new Brand("Maxi"), new InUse(Boolean.FALSE));
        var useCase = new AddMixerUseCase();

        Mockito.when(repository.getEventsBy(RootId)).thenReturn(List.of(
                new ProductionCreated(
                        new StoreName("Store")
                )
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(RootId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding a Mixer"))
                .getDomainEvents();

        var event = (MixerAdded) events.get(0);
        Assertions.assertEquals(command.getBrand().value(), event.getBrand().value());
        Assertions.assertEquals(command.getInUse().value(), event.getInUse().value());
        Assertions.assertEquals(command.getEntityId().value(), event.getEntityId().value());
    }

}
