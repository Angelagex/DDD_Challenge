package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.logistic.Logistic;
import com.sofkaU.DDDChallenge.logistic.commands.AddWaiter;

public class AddWaiterUseCase extends UseCase<RequestCommand<AddWaiter>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AddWaiter> addWaiterRequestCommand) {
        var command = addWaiterRequestCommand.getCommand();
        var logistic = Logistic.from(command.getLogisticId(), retrieveEvents(command.getLogisticId().value()));
        logistic.AddWaiter(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(logistic.getUncommittedChanges()));
    }
}
