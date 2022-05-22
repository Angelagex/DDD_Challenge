package com.sofkaU.DDDChallenge.logistic.values;

import co.com.sofka.domain.generic.Identity;

public class BodyguardId extends Identity {

    public BodyguardId(String uuid) {
        super(uuid);
    }

    public BodyguardId() {
    }

    public static BodyguardId of(String id) {
        return new BodyguardId(id);
    }

}
