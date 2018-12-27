package itsgosho.domain.services;

import itsgosho.domain.entities.Capital;

import java.util.List;

public interface CapitalServices {

    //FOR TESTING PURPOSES :)
    void transformIDsToUUIDs();

    List<Capital> getAllCapitals();
}
