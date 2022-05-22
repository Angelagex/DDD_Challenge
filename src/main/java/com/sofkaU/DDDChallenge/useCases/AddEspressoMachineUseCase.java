package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.production.Production;
import com.sofkaU.DDDChallenge.production.commands.AddEspressoMachine;

public class AddEspressoMachineUseCase extends UseCase<RequestCommand<AddEspressoMachine>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddEspressoMachine> addEspressoMachineRequestCommand) {
        var command = addEspressoMachineRequestCommand.getCommand();
        var production = Production.from(command.getProductionId(), retrieveEvents(command.getProductionId().value()));
        production.AddEspressoMachine(command.getEntityId(), command.getBrand(), command.getInUse());

        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));
    }
}
