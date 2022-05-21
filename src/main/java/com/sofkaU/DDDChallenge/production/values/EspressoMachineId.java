package com.sofkaU.DDDChallenge.production.values;

import co.com.sofka.domain.generic.Identity;

public class EspressoMachineId extends Identity {

    private EspressoMachineId(String uuid) {
        super(uuid);
    }

    public EspressoMachineId() {
    }

    public static EspressoMachineId of(String id){
        return new EspressoMachineId(id);
    }

}
