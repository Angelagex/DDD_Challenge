package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.logistic.Logistic;
import com.sofkaU.DDDChallenge.logistic.commands.CreateLogistic;

public class CreateLogisticUseCase extends UseCase<RequestCommand<CreateLogistic>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CreateLogistic> createLogisticRequestCommand) {

        var command = createLogisticRequestCommand.getCommand();
        var production = new Logistic(
                command.getEntityId(),
                command.getStoreName()
        );
        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));

    }
}
