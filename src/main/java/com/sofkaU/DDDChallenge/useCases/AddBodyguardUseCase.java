package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.logistic.Logistic;
import com.sofkaU.DDDChallenge.logistic.commands.AddBodyguard;
import com.sofkaU.DDDChallenge.production.Production;


public class AddBodyguardUseCase extends UseCase<RequestCommand<AddBodyguard>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<AddBodyguard> addBodyguardRequestCommand) {
        var command = addBodyguardRequestCommand.getCommand();
        var logistic = Logistic.from(command.getLogisticId(), retrieveEvents(command.getLogisticId().value()));
        logistic.AddBodyguard(command.getEntityId(), command.getName(), command.getYearsOfExperience());

        emit().onResponse(new ResponseEvents(logistic.getUncommittedChanges()));
    }
}
