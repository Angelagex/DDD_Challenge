package com.sofkaU.DDDChallenge.production.values;

import co.com.sofka.domain.generic.Identity;

public class MixerId extends Identity {

    private MixerId(String uuid) {
        super(uuid);
    }

    public MixerId() {
    }

    public static MixerId of(String id){
        return new MixerId(id);
    }
}
