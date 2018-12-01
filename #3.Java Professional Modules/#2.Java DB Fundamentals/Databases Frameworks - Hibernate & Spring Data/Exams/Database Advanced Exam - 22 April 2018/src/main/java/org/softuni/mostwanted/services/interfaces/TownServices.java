package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.entities.Town;

public interface TownServices {

    boolean save(Town town);
    void seedDatabase();
    void exportRacingTowns();
}
