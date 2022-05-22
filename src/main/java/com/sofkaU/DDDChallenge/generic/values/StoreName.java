package com.sofkaU.DDDChallenge.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class StoreName implements ValueObject<String>{

    private final String value;

    public StoreName(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("StoreName can´t be blank");
        }
        if (this.value.length() < 2){
            throw new IllegalArgumentException("StoreName needs to have at least 2 characters");
        }
        if (this.value.length() >= 30){
            throw new IllegalArgumentException("StoreName needs to have less than 30 characters");
        }
    }
    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreName storeName = (StoreName) o;
        return value.equals(storeName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
