package mostwanted.service.inter;

import java.io.IOException;

public interface RacerService {

    Boolean racersAreImported();

    String readRacersJsonFile() throws IOException;

    String importRacers(String racersFileContent);

    String exportRacingCars();
}
