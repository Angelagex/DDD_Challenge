package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.production.Production;
import com.sofkaU.DDDChallenge.production.commands.AddMixer;

public class AddMixerUseCase extends UseCase<RequestCommand<AddMixer>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddMixer> addMixerRequestCommand) {
        var command = addMixerRequestCommand.getCommand();
        var production = Production.from(command.getProductionId(), retrieveEvents(command.getProductionId().value()));
        production.AddMixer(command.getEntityId(), command.getBrand(), command.getInUse());

        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));
    }
}
