package com.sofkaU.DDDChallenge.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class InUse implements ValueObject<Boolean> {

    private final Boolean value;

    public InUse(Boolean value) {
        this.value = Objects.requireNonNull(value);
    }
    public Boolean value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InUse inUse = (InUse) o;
        return value.equals(inUse.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
