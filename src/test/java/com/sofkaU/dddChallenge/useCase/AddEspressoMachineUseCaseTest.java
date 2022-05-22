package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.commands.AddEspressoMachine;
import com.sofkaU.DDDChallenge.production.events.EspressoMachineAdded;
import com.sofkaU.DDDChallenge.production.events.ProductionCreated;
import com.sofkaU.DDDChallenge.production.values.EspressoMachineId;
import com.sofkaU.DDDChallenge.production.values.ProductionId;
import com.sofkaU.DDDChallenge.useCases.AddEspressoMachineUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddEspressoMachineUseCaseTest {


    private final String RootId = "Idct1";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addEspressoMachine(){

        var command = new AddEspressoMachine(ProductionId.of(RootId), EspressoMachineId.of("EM1"), new Brand("Xiaomi"), new InUse(Boolean.FALSE));
        var useCase = new AddEspressoMachineUseCase();

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
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding a EspressoMachine"))
                .getDomainEvents();

        var event = (EspressoMachineAdded) events.get(0);
        Assertions.assertEquals(command.getBrand().value(), event.getBrand().value());
        Assertions.assertEquals(command.getInUse().value(), event.getInUse().value());
        Assertions.assertEquals(command.getEntityId().value(), event.getEntityId().value());
    }
}
