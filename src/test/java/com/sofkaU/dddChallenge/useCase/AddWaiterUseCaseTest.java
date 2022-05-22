package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.logistic.commands.AddWaiter;
import com.sofkaU.DDDChallenge.logistic.events.WaiterAdded;
import com.sofkaU.DDDChallenge.logistic.events.LogisticCreated;
import com.sofkaU.DDDChallenge.logistic.values.WaiterId;
import com.sofkaU.DDDChallenge.logistic.values.LogisticId;
import com.sofkaU.DDDChallenge.useCases.AddWaiterUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddWaiterUseCaseTest {

    private final String RootId = "05432";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addWaiter(){

        var command = new AddWaiter(LogisticId.of(RootId), WaiterId.of("18892"), new Name("Jhonny"));
        var useCase = new AddWaiterUseCase();

        Mockito.when(repository.getEventsBy(RootId)).thenReturn(List.of(
                new LogisticCreated(
                        new StoreName("Store")
                )
        ));

        useCase.addRepository(repository);

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(RootId)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding a Waiter"))
                .getDomainEvents();

        var event = (WaiterAdded) events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getEntityId().value(), event.getEntityId().value());
    }
}
