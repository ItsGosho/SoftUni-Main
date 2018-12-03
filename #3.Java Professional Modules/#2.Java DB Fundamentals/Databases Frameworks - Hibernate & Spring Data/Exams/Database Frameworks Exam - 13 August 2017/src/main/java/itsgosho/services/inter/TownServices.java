package itsgosho.services.inter;

import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.Town;

public interface TownServices {

    boolean save(Town town);
    void seedDatabase();

    void exportTowns();
}
