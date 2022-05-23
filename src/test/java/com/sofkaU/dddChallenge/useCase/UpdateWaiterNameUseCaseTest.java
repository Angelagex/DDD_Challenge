package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.logistic.commands.UpdateWaiterName;
import com.sofkaU.DDDChallenge.logistic.events.WaiterNameUpdated;
import com.sofkaU.DDDChallenge.logistic.events.LogisticCreated;
import com.sofkaU.DDDChallenge.logistic.values.WaiterId;
import com.sofkaU.DDDChallenge.logistic.values.LogisticId;
import com.sofkaU.DDDChallenge.useCases.UpdateWaiterNameUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UpdateWaiterNameUseCaseTest {

        private final String RootId = "123";

        @Mock
        private DomainEventRepository repository;

        @Test
        void updateWaiterNameTest(){

            var command = new UpdateWaiterName(LogisticId.of(RootId), WaiterId.of("dddd"), new Name("José Angel"));
            var useCase = new UpdateWaiterNameUseCase();

            Mockito.when(repository.getEventsBy(RootId)).thenReturn(List.of(
                    new LogisticCreated(
                            new StoreName("littleStore")
                    )
            ));


            useCase.addRepository(repository);

            var events = UseCaseHandler
                    .getInstance()
                    .setIdentifyExecutor(RootId)
                    .syncExecutor(useCase, new RequestCommand<>(command))
                    .orElseThrow(() -> new IllegalArgumentException("Something went wrong adding a Waiter"))
                    .getDomainEvents();

            var event = (WaiterNameUpdated) events.get(1);
            Assertions.assertEquals(command.getName().value(), event.getName().value());
            Assertions.assertEquals(command.getEntityId().value(), event.getEntityId().value());
        }

    }
