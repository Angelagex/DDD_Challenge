package com.sofkaU.DDDChallenge.useCases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.production.Production;
import com.sofkaU.DDDChallenge.production.commands.UpdateBaristaName;
import com.sofkaU.DDDChallenge.production.values.BaristaId;

public class UpdateBaristaNameUseCase extends UseCase<RequestCommand<UpdateBaristaName>, ResponseEvents> {


    @Override
    public void executeUseCase(RequestCommand<UpdateBaristaName> updateBaristaNameRequestCommand) {
        var command = updateBaristaNameRequestCommand.getCommand();
        var production = Production.from(command.getProductionId(), retrieveEvents(command.getProductionId().value()));
        production.AddBarista(BaristaId.of("dddd"), new Name("Angel"), new YearsOfExperience("1"));
        production.UpdateBaristaName(command.getEntityId(), command.getName());

        emit().onResponse(new ResponseEvents(production.getUncommittedChanges()));
    }
}
