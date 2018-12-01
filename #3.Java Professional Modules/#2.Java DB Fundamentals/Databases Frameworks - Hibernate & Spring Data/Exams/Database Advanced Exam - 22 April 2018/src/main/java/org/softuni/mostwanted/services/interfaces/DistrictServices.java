package org.softuni.mostwanted.services.interfaces;

import org.softuni.mostwanted.domain.entities.District;

public interface DistrictServices {

    boolean save(District district);

    void seedDatabase();
}
