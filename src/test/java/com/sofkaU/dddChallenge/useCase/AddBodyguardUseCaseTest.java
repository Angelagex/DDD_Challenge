package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.logistic.commands.AddBodyguard;
import com.sofkaU.DDDChallenge.logistic.events.BodyguardAdded;
import com.sofkaU.DDDChallenge.logistic.events.LogisticCreated;
import com.sofkaU.DDDChallenge.logistic.values.BodyguardId;
import com.sofkaU.DDDChallenge.logistic.values.LogisticId;
import com.sofkaU.DDDChallenge.useCases.AddBodyguardUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddBodyguardUseCaseTest {
    private final String RootId = "432";

    @Mock
    private DomainEventRepository repository;

    @Test
    void addBodyguard(){

        var command = new AddBodyguard(LogisticId.of(RootId), BodyguardId.of("Id2"), new Name("Pedro"), new YearsOfExperience("4"));
        var useCase = new AddBodyguardUseCase();

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
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding a Bodyguard"))
                .getDomainEvents();

        var event = (BodyguardAdded) events.get(0);
        Assertions.assertEquals(command.getName().value(), event.getName().value());
        Assertions.assertEquals(command.getYearsOfExperience().value(), event.getYearsOfExperience().value());
        Assertions.assertEquals(command.getEntityId().value(), event.getEntityId().value());
    }
}
