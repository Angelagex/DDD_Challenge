package com.sofkaU.DDDChallenge.production;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkaU.DDDChallenge.generic.values.*;
import com.sofkaU.DDDChallenge.production.entities.*;
import com.sofkaU.DDDChallenge.production.events.*;
import com.sofkaU.DDDChallenge.production.values.*;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Production extends AggregateEvent<ProductionId> {

    protected StoreName storeName;
    protected Set<EspressoMachine> espressoMachines;
    protected Set<Barista> baristas;
    protected Set<Mixer> mixers;

    //Constructors

    public Production(ProductionId entityId, StoreName storeName) {
        super(entityId);
        appendChange(new ProductionCreated(storeName)).apply();
    }

    public Production(ProductionId productionId){
        super(productionId);
        subscribe(new ProductionChange(this));
    }

    public static Production from(ProductionId productionId, List<DomainEvent> events){
        Production production = new Production(productionId);
        events.forEach(production::applyEvent);
        return production;
    }


    //Behaviours

    public void UpdateStoreName(StoreName storeName){
        appendChange(new StoreNameUpdated(storeName)).apply();
    }

    public void AddEspressoMachine(EspressoMachineId entityId, Brand brand, InUse inUse){
        Objects.requireNonNull(entityId,"EspressoMachineId can't be null");
        Objects.requireNonNull(brand, "Brand can't be null");
        Objects.requireNonNull(inUse, "InUse can't be null");
        appendChange(new EspressoMachineAdded(entityId, brand, inUse)).apply();
    }

    public void AddBarista(BaristaId entityId, Name name, YearsOfExperience yearsOfExperience){
        Objects.requireNonNull(entityId,"BaristaId can't be null");
        Objects.requireNonNull(name, "Name can't be null");
        Objects.requireNonNull(yearsOfExperience, "YearsOfExperience can't be null");
        appendChange(new BaristaAdded(entityId, name, yearsOfExperience)).apply();
    }

    public void AddMixer(MixerId entityId, Brand brand, InUse inUse){
        Objects.requireNonNull(entityId,"MixerId can't be null");
        Objects.requireNonNull(brand, "Brand can't be null");
        Objects.requireNonNull(inUse, "InUse can't be null");
        appendChange(new MixerAdded(entityId, brand, inUse)).apply();
    }

    public void UpdateEspressoMachineBrand(EspressoMachineId entityId, Brand brand){
        appendChange(new EspressoMachineBrandUpdated(entityId, brand)).apply();
    }

    public void UpdateEspressoMachineInUse(EspressoMachineId entityId, InUse inUse){
        appendChange(new EspressoMachineInUseUpdated(entityId, inUse)).apply();
    }

    public void UpdateBaristaName(BaristaId entityId, Name name){
        appendChange(new BaristaNameUpdated(entityId, name)).apply();
    }

    public void UpdateBaristaYearsOfExperience(BaristaId entityId, YearsOfExperience yearsOfExperience){
        appendChange(new BaristaYearsOfExperienceUpdated(entityId, yearsOfExperience)).apply();
    }

    public void UpdateMixerBrand(MixerId entityId, Brand brand){
        appendChange(new MixerBrandUpdated(entityId, brand)).apply();
    }

    public void UpdateMixerInUse(MixerId entityId, InUse inUse){
        appendChange(new MixerInUseUpdated(entityId, inUse)).apply();
    }

    //Retrievers

    public StoreName storeName() {
        return storeName;
    }

    public Set<EspressoMachine> espressoMachines() {
        return espressoMachines;
    }

    public Set<Barista> baristas() {
        return baristas;
    }

    public Set<Mixer> mixers() {
        return mixers;
    }
}
