package com.sofkaU.DDDChallenge.logistic.values;

import co.com.sofka.domain.generic.Identity;
import com.sofkaU.DDDChallenge.production.values.ProductionId;

public class LogisticId extends Identity {
    public LogisticId(String uuid) {
        super(uuid);
    }

    public LogisticId() {
    }

    public static LogisticId of(String id){
        return new LogisticId(id);
    }
}
