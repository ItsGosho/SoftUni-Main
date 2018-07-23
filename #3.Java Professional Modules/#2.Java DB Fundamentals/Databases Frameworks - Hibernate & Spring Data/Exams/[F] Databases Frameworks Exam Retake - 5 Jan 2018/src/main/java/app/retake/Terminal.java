package app.retake;

import app.retake.controllers.AnimalAidController;
import app.retake.controllers.AnimalController;
import app.retake.controllers.ProcedureController;
import app.retake.controllers.VetController;
import app.retake.io.api.ConsoleIO;
import app.retake.io.api.FileIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private AnimalAidController animalAidController;
    @Autowired
    private AnimalController animalController;
    @Autowired
    private VetController vetController;
    @Autowired
    private ProcedureController procedureController;

    @Override
    public void run(String... strings) throws Exception {

        System.out.println(this.animalAidController.importDataFromJSON(Config.ANIMAL_AIDS_IMPORT_JSON));
        System.out.println(this.animalController.importDataFromJSON(Config.ANIMALS_IMPORT_JSON));
        System.out.println(this.vetController.importDataFromXML(Config.VETS_IMPORT_XML));
        System.out.println(procedureController.importDataFromXML(Config.PROCEDURES_IMPORT_XML));
        System.out.println(this.animalController.exportAnimalsByOwnerPhoneNumber("0887446123"));
        System.out.println(this.procedureController.exportProcedures());
    }
}
