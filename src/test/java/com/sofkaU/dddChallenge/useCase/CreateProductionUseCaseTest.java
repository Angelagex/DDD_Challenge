package com.sofkaU.dddChallenge.useCase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.sofkaU.DDDChallenge.generic.values.StoreName;
import com.sofkaU.DDDChallenge.production.commands.CreateProduction;
import com.sofkaU.DDDChallenge.production.events.ProductionCreated;
import com.sofkaU.DDDChallenge.production.values.ProductionId;
import com.sofkaU.DDDChallenge.useCases.CreateProductionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateProductionUseCaseTest {

    @Test
    void createProductionWithAllParameters(){
        //Arrange
        var command = new CreateProduction(
                ProductionId.of("1234"),
                new StoreName("Store1")
        );

        var useCase = new CreateProductionUseCase();

        //Act

        var events = UseCaseHandler
                .getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Something went wrong creating the Production"))
                .getDomainEvents();

        //Assert

        var event = (ProductionCreated) events.get(0);
        Assertions.assertEquals(command.getStoreName().value(), event.getStoreName().value());
    }


}
