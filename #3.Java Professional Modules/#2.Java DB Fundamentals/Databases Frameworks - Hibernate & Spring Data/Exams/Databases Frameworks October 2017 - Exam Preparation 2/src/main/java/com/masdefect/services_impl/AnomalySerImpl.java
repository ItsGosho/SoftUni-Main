package com.masdefect.services_impl;

import com.masdefect.domain.dto.json.AnomalyExportJSONDto;
import com.masdefect.domain.dto.json.AnomalyImportJSONDto;
import com.masdefect.domain.dto.json.AnomalyVictimsJSONDto;
import com.masdefect.domain.dto.xml.AnomaliesXMLDto;
import com.masdefect.domain.dto.xml.AnomalyXMLDto;
import com.masdefect.domain.entities.Anomaly;
import com.masdefect.parser.interfaces.ModelParser;
import com.masdefect.repository.AnomalyRepository;
import com.masdefect.repository.PersonRepository;
import com.masdefect.repository.PlanetRepository;
import com.masdefect.service.AnomalyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AnomalySerImpl implements AnomalyService {

    @Autowired
    private AnomalyRepository anomalyRepository;
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void create(AnomalyImportJSONDto anomalyImpotJSONDto) {
        Anomaly anomaly=this.modelParser.convert(anomalyImpotJSONDto,Anomaly.class);
        anomaly.setHomePlanet(this.planetRepository.findPlanetByName(anomalyImpotJSONDto.getTeleportPlanet()));
        anomaly.setOriginPlanet(this.planetRepository.findPlanetByName(anomalyImpotJSONDto.getOriginPlanet()));
        this.anomalyRepository.save(anomaly);
    }

    @Override
    public void create(AnomalyVictimsJSONDto anomalyVictimsDto) {
       Anomaly anomaly=this.anomalyRepository.findAnomalyById(anomalyVictimsDto.getId());
       anomaly.setVictims(new LinkedList<>());
       anomaly.getVictims().add(this.personRepository.findPersonByName(anomalyVictimsDto.getPerson()));
       this.anomalyRepository.save(anomaly);
    }

    @Override
    public void create(AnomalyXMLDto anomalyImportXMLDto) {

    }

    @Override
    public AnomalyExportJSONDto findMostAffectingAnomalies() {
        return null;
    }

    @Override
    public AnomaliesXMLDto finaAllAnomalies() {
        List<Anomaly> anomalies = this.anomalyRepository.getAllByOrderByIdAsc();
        AnomalyXMLDto[] anomalyXMLDto =
                this.modelParser.convert(anomalies,AnomalyXMLDto[].class);
        AnomaliesXMLDto anomaliesXMLDto = new AnomaliesXMLDto();
        anomaliesXMLDto.setAnomalies(new LinkedList<>());
        for (AnomalyXMLDto xmlDto : anomalyXMLDto) {
            anomaliesXMLDto.getAnomalies().add(xmlDto);
        }
        return anomaliesXMLDto;
    }
}
