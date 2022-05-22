package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.production.Production;
import com.sofkaU.DDDChallenge.production.commands.CreateProduction;

public class CreateProductionUseCase extends UseCase<RequestCommand<CreateProduction>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<CreateProduction> createProductionRequestCommand) {
        var command = createProductionRequestCommand.getCommand();
        var production = new Production(
                command.getEntityId(),
                command.getStoreName()
        );
        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));
    }
}
