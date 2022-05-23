package com.sofkaU.DDDChallenge.logistic.entities;

import co.com.sofka.domain.generic.Entity;
import com.sofkaU.DDDChallenge.generic.values.Name;
import com.sofkaU.DDDChallenge.generic.values.YearsOfExperience;
import com.sofkaU.DDDChallenge.logistic.values.BodyguardId;

import java.util.Objects;

public class Bodyguard extends Entity<BodyguardId> {

    private YearsOfExperience yearsOfExperience;
    private Name name;

    public Bodyguard(BodyguardId entityId,  Name name, YearsOfExperience yearsOfExperience) {
        super(entityId);
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;

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
