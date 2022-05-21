package com.sofkaU.DDDChallenge.production.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.DDDChallenge.generic.values.Brand;
import com.sofkaU.DDDChallenge.generic.values.InUse;
import com.sofkaU.DDDChallenge.production.values.EspressoMachineId;

import java.util.Objects;

public class EspressoMachine extends Entity<EspressoMachineId> {


    private Brand brand;
    private InUse inUse;

    public EspressoMachine(EspressoMachineId entityId, Brand brand, InUse inUse) {
        super(entityId);
        this.brand = brand;
        this.inUse = inUse;
    }

    public void UpdateBrand(Brand brand) {
        this.brand = Objects.requireNonNull(brand);
    }

    public void UpdateInUse(InUse inUse) {
        this.inUse = Objects.requireNonNull(inUse);
    }

    public Brand Brand() {
        return brand;
    }

    public InUse InUse() {
        return inUse;
    }
}
