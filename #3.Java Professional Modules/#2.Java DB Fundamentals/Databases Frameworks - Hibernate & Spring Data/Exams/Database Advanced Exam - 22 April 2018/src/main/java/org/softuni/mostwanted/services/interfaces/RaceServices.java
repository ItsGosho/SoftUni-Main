package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Race;

public interface RaceServices {

    boolean save(Race race);

    void seedDatabase();
}
