package com.sofkaU.DDDChallenge.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class YearsOfExperience implements ValueObject<String> {

    private final String value;

    public YearsOfExperience(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("YearsOfExperience can´t be blank");
        }
        if (Double.parseDouble(this.value)<1){
            throw new IllegalArgumentException("YearsOfExperience can't be lower than 1");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearsOfExperience that = (YearsOfExperience) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
