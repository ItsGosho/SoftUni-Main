package org.softuni.mostwanted.terminal;

import org.softuni.mostwanted.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class Terminal implements CommandLineRunner {

    private final TownServices townServices;
    private final DistrictServices districtServices;
    private final RacerServices racerServices;
    private final CarServices carServices;
    private final RaceEntryServices raceEntryServices;
    private final RaceServices raceServices;

    @Autowired
    public Terminal(TownServices townServices, DistrictServices districtServices, RacerServices racerServices, CarServices carServices, RaceEntryServices raceEntryServices, RaceServices raceServices) {
        this.townServices = townServices;
        this.districtServices = districtServices;
        this.racerServices = racerServices;
        this.carServices = carServices;
        this.raceEntryServices = raceEntryServices;
        this.raceServices = raceServices;
    }

    @Override
    public void run(String... args) throws Exception {
        this.townServices.seedDatabase();
        this.districtServices.seedDatabase();
        this.racerServices.seedDatabase();
        this.carServices.seedDatabase();
        this.raceEntryServices.seedDatabase();
        this.raceServices.seedDatabase();

        this.racerServices.exportMostWanted();
        this.townServices.exportRacingTowns();
        this.racerServices.exportRacingCars();
    }
}
