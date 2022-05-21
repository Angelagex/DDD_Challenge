package com.sofkaU.DDDChallenge.production.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.DDDChallenge.generic.values.Brand;
import com.sofkaU.DDDChallenge.generic.values.InUse;
import com.sofkaU.DDDChallenge.production.values.MixerId;

import java.util.Objects;

public class Mixer extends Entity<MixerId> {

    private Brand brand;
    private InUse inUse;

    public Mixer(MixerId entityId, Brand brand, InUse inUse) {
        super(entityId);
        this.brand = brand;
        this.inUse = inUse;
    }

    public void UpdateBrand(Brand brand) {
        this.brand = Objects.requireNonNull(brand, "Brand can´t be null");
    }

    public void UpdateInUse(InUse inUse) {
        this.inUse = Objects.requireNonNull(inUse, "InUse can´t be null");
    }

    public Brand Brand() {
        return brand;
    }

    public InUse InUse() {
        return inUse;
    }
}
