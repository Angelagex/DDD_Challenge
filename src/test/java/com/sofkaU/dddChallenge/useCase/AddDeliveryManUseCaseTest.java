package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.logistic.commands.AddDeliveryMan;
import com.sofkaU.DDDChallenge.logistic.events.DeliveryManAdded;
import com.sofkaU.DDDChallenge.logistic.events.LogisticCreated;
import com.sofkaU.DDDChallenge.logistic.values.DeliveryManId;
import com.sofkaU.DDDChallenge.logistic.values.LogisticId;
import com.sofkaU.DDDChallenge.useCases.AddDeliveryManUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddDeliveryManUseCaseTest {
    private final String RootId = "41232";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addDeliveryMan(){

        var command = new AddDeliveryMan(LogisticId.of(RootId), DeliveryManId.of("Id2"), new Name("Juan"));
        var useCase = new AddDeliveryManUseCase();

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
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding a DeliveryMan"))
                .getDomainEvents();

        var event = (DeliveryManAdded) events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getEntityId().value(), event.getEntityId().value());
    }
}
