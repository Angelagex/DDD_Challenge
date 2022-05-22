package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.logistic.Logistic;
import com.sofkaU.DDDChallenge.logistic.commands.AddDeliveryMan;

public class AddDeliveryManUseCase extends UseCase<RequestCommand<AddDeliveryMan>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddDeliveryMan> addDeliveryManRequestCommand) {
        var command = addDeliveryManRequestCommand.getCommand();
        var logistic = Logistic.from(command.getLogisticId(), retrieveEvents(command.getLogisticId().value()));
        logistic.AddDeliveryMan(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(logistic.getUncommittedChanges()));
    }
}
