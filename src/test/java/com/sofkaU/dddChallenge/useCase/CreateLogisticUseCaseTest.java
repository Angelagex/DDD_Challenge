package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.DDDChallenge.generic.values.StoreName;

import com.sofkaU.DDDChallenge.logistic.commands.CreateLogistic;
import com.sofkaU.DDDChallenge.logistic.events.LogisticCreated;
import com.sofkaU.DDDChallenge.logistic.values.LogisticId;
import com.sofkaU.DDDChallenge.useCases.CreateLogisticUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateLogisticUseCaseTest {

    @Test
    void createLogisticWithAllParameters(){
        //Arrange
        var command = new CreateLogistic(
                LogisticId.of("321"),
                new StoreName("little store")
        );

        var useCase = new CreateLogisticUseCase();

        //Act

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong creating the Logistic"))
                .getDomainEvents();

        //Assert

        var event = (LogisticCreated) events.get(0);
        Assertions.assertEquals(command.getStoreName().value(), event.getStoreName().value());
    }
}
