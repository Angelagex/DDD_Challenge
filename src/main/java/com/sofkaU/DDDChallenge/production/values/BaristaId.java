package com.sofkaU.DDDChallenge.production.values;

import co.com.sofka.domain.generic.Identity;

public class BaristaId extends Identity {

    private BaristaId(String uuid) {
        super(uuid);
    }

    public BaristaId() {
    }

    public static BaristaId of(String id){
        return new BaristaId(id);
    }

}
