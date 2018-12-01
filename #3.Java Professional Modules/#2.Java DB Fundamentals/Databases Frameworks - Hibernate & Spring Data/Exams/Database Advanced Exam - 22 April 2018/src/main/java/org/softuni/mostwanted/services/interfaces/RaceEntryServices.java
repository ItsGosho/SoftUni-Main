package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.entities.RaceEntry;

public interface RaceEntryServices {

    boolean save(RaceEntry raceEntry);

    void seedDatabase();
}
