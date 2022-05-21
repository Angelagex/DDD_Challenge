package com.sofkaU.DDDChallenge.production;

import co.com.sofka.domain.generic.EventChange;
import com.sofkaU.DDDChallenge.production.entities.*;
import com.sofkaU.DDDChallenge.production.events.*;

import java.util.HashSet;

public class ProductionChange extends EventChange {
    public ProductionChange(Production production) {

        apply( (ProductionCreated event) -> {
            production.storeName = event.getStoreName();
            production.espressoMachines = new HashSet<>();
            production.baristas = new HashSet<>();
            production.mixers = new HashSet<>();
        });

        apply( (StoreNameUpdated event) -> {
            production.storeName = event.getStoreName();
        });

        apply( (BaristaAdded event) -> {
            var nBaristas = production.baristas().size();
            if(nBaristas >= 3){
                throw new IllegalArgumentException("You can only have 3 Baristas");
            }
            production.baristas.add(new Barista(
                    event.getEntityId(),
                    event.getYearsOfExperience(),
                    event.getName()
            ));
        });

        apply((BaristaNameUpdated event) -> {
            var barista = production.getBaristaById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Barista can't be found"));
            barista.UpdateName(event.getName());
        });

        apply((BaristaYearsOfExperienceUpdated event) -> {
            var barista = production.getBaristaById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Barista can't be found"));
            barista.UpdateYearsOfExperience(event.getYearsOfExperience());
        });

        apply( (EspressoMachineAdded event) -> {
            var nEspressoMachines = production.espressoMachines().size();
            if(nEspressoMachines >= 3){
                throw new IllegalArgumentException("You can only have 3 Espresso Machines");
            }
            production.espressoMachines.add(new EspressoMachine(
                    event.getEntityId(),
                    event.getBrand(),
                    event.getInUse()
            ));
        });

        apply((EspressoMachineBrandUpdated event) -> {
            var espressoMachine = production.getEspressoMachineById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Espresso Machine can't be found"));
            espressoMachine.UpdateBrand(event.getBrand());
        });

        apply((EspressoMachineInUseUpdated event) -> {
            var espressoMachine = production.getEspressoMachineById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Espresso Machine can't be found"));
            espressoMachine.UpdateInUse(event.getInUse());
        });

        apply( (MixerAdded event) -> {
            var nMixers = production.mixers().size();
            if(nMixers >= 2){
                throw new IllegalArgumentException("You can only have 2 Mixers");
            }
            production.mixers.add(new Mixer(
                    event.getEntityId(),
                    event.getBrand(),
                    event.getInUse()
            ));
        });

        apply((MixerBrandUpdated event) -> {
            var mixer = production.getMixerById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Mixer can't be found"));
            mixer.UpdateBrand(event.getBrand());
        });

        apply((MixerInUseUpdated event) -> {
            var mixer = production.getMixerById(event.getEntityId())
                    .orElseThrow(() -> new IllegalArgumentException("Mixer can't be found"));
            mixer.UpdateInUse(event.getInUse());
        });
    }
}
