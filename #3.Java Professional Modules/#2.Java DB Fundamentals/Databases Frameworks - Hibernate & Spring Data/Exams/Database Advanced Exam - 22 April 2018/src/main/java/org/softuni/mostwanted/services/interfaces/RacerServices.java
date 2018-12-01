package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Racer;

public interface RacerServices {

    boolean save(Racer racer);

    void seedDatabase();

    void exportMostWanted();

    void exportRacingCars();
}
