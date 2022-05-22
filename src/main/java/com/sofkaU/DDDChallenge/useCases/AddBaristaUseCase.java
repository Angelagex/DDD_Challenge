package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.production.Production;
import com.sofkaU.DDDChallenge.production.commands.AddBarista;

public class AddBaristaUseCase extends UseCase<RequestCommand<AddBarista>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddBarista> addBaristaRequestCommand) {
        var command = addBaristaRequestCommand.getCommand();
        var production = Production.from(command.getProductionId(), retrieveEvents(command.getProductionId().value()));
        production.AddBarista(command.getEntityId(), command.getName(), command.getYearsOfExperience());

        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));
    }
}
