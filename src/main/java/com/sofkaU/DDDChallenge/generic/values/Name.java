package com.sofkaU.DDDChallenge.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Name implements ValueObject<String> {

    private final String value;

    public Name(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("Name can´t be blank");
        }
        if (this.value.length() < 2){
            throw new IllegalArgumentException("Name needs to have at least 2 characters");
        }
        if (this.value.length() >= 30){
            throw new IllegalArgumentException("Name needs to have less than 30 characters");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name = (Name) o;
        return value.equals(name.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
