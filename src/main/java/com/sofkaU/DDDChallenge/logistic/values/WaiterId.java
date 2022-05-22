package com.sofkaU.DDDChallenge.logistic.values;

import co.com.sofka.domain.generic.Identity;

public class WaiterId extends Identity {
    public WaiterId(String uuid) {
        super(uuid);
    }

    public WaiterId() {
    }

    public static WaiterId of(String id) {
        return new WaiterId(id);
    }
}
