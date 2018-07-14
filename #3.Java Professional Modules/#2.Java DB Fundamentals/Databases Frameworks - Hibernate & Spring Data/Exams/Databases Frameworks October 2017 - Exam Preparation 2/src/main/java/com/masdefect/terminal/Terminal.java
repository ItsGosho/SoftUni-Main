package com.masdefect.terminal;

import com.masdefect.config.Config;
import com.masdefect.controller.*;
import com.masdefect.domain.dto.xml.AnomaliesXMLDto;
import com.masdefect.domain.dto.xml.AnomalyXMLDto;
import com.masdefect.domain.dto.xml.VictimXMLDto;
import com.masdefect.parser.XMLParser;
import com.masdefect.parser.interfaces.FileParser;
import com.masdefect.service.AnomalyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.*;
import java.io.*;
import java.util.LinkedList;

@Component
public class Terminal implements CommandLineRunner {

    private final SolarSystemController solarSystemController;
    private final StarsController starsController;
    private final PlanetsController planetsController;
    private final PersonsController personsController;
    private final AnomalyController anomalyController;
    private final AnomalyVictimsController anomalyVictimsController;

    @Autowired
    public Terminal(SolarSystemController solarSystemController, StarsController starsController, PlanetsController planetsController, PersonsController personsController, AnomalyController anomalyController, AnomalyVictimsController anomalyVictimsController) {
        this.solarSystemController = solarSystemController;
        this.starsController = starsController;
        this.planetsController = planetsController;
        this.personsController = personsController;
        this.anomalyController = anomalyController;
        this.anomalyVictimsController = anomalyVictimsController;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.anomalyController.exportAnomaliesOrdered());
    }

    public void importAll() throws IOException, JAXBException {
        System.out.println(this.solarSystemController.importDataFromJSON(Config.SOLAR_SYSTEM_IMPORT_JSON));
        System.out.println(this.starsController.importDataFromJSON(Config.STARS_IMPORT_JSON));
        System.out.println(this.planetsController.importDataFromJSON(Config.PLANETS_IMPORT_JSON));
        System.out.println(this.personsController.importDataFromJSON(Config.PERSONS_IMPORT_JSON));
        System.out.println(this.anomalyController.importDataFromJSON(Config.ANOMALY_IMPORT_JSON));
        System.out.println(this.anomalyVictimsController.importDataFromJSON(Config.ANOMALY_VICTIMS_IMPORT_JSON));
        System.out.println(this.anomalyController.importDataFromXML(Config.ANOMALIES_IMPORT_XML));
    }
}
