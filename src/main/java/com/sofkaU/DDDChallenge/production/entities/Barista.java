package com.sofkaU.DDDChallenge.production.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.production.values.BaristaId;

import java.util.Objects;

public class Barista extends Entity<BaristaId> {

    private YearsOfExperience yearsOfExperience;
    private Name name;

    public Barista(BaristaId entityId, YearsOfExperience yearsOfExperience, Name name) {
        super(entityId);
        this.yearsOfExperience = yearsOfExperience;
        this.name = name;
    }

    public void UpdateYearsOfExperience(YearsOfExperience yearsOfExperience) {
        this.yearsOfExperience = Objects.requireNonNull(yearsOfExperience, "YearsOfExperience can´t be null");
    }

    public void UpdateName(Name name) {
        this.name = Objects.requireNonNull(name, "Name can´t be null");
    }

    public YearsOfExperience yearsOfExperience() {
        return yearsOfExperience;
    }

    public Name name() {
        return name;
    }
}
