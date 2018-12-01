package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.entities.Car;

public interface CarServices {

    boolean save(Car car);

    void seedDatabase();
}
