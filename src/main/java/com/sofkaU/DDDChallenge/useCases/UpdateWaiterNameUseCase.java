package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.logistic.Logistic;
import com.sofkaU.DDDChallenge.logistic.commands.UpdateBodyguardName;
import com.sofkaU.DDDChallenge.logistic.commands.UpdateWaiterName;
import com.sofkaU.DDDChallenge.logistic.values.BodyguardId;
import com.sofkaU.DDDChallenge.logistic.values.WaiterId;


public class UpdateWaiterNameUseCase extends UseCase<RequestCommand<UpdateWaiterName>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<UpdateWaiterName> updateWaiterNameRequestCommand) {
        var command = updateWaiterNameRequestCommand.getCommand();
        var logistic = Logistic.from(command.getLogisticId(), retrieveEvents(command.getLogisticId().value()));
        logistic.AddWaiter(WaiterId.of("dddd"), new Name("Angel"));
        logistic.UpdateWaiterName(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(logistic.getUncommittedChanges()));
    }
}
