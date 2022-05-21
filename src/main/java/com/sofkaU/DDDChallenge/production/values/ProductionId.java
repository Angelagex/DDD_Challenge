package com.sofkaU.DDDChallenge.production.values;

import co.com.sofka.domain.generic.Identity;

public class ProductionId extends Identity {

    private ProductionId(String uuid) {
        super(uuid);
    }

    public ProductionId() {
    }

    public static ProductionId of(String id){
        return new ProductionId(id);
    }
}
