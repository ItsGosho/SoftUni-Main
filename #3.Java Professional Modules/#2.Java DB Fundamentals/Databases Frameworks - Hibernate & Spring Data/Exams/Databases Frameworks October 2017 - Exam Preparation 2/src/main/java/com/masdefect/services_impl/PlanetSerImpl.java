package com.masdefect.services_impl;

import com.masdefect.domain.dto.json.PlanetExportJSONDto;
import com.masdefect.domain.dto.json.PlanetImportJSONDto;
import com.masdefect.domain.entities.Planet;
import com.masdefect.domain.entities.SolarSystem;
import com.masdefect.domain.entities.Star;
import com.masdefect.parser.interfaces.ModelParser;
import com.masdefect.repository.PlanetRepository;
import com.masdefect.repository.SolarSystemRepository;
import com.masdefect.repository.StarRepository;
import com.masdefect.service.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetSerImpl implements PlanetService {
    @Autowired
    private PlanetRepository planetRepository;
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private SolarSystemRepository solarSystemRepository;
    @Autowired
    private StarRepository starRepository;

    @Override
    public void create(PlanetImportJSONDto planetImportJSONDto) {
        Planet planet=this.modelParser.convert(planetImportJSONDto,Planet.class);
        Star star=this.starRepository.findStarByName(planetImportJSONDto.getSun());
        SolarSystem solarSystem=this.solarSystemRepository.findSolarSystemByName(planetImportJSONDto.getSolarSystem());
        planet.setSun(star);
        planet.setSolarSystem(solarSystem);
        this.planetRepository.save(planet);
    }

    @Override
    public List<PlanetExportJSONDto> findAllPlanetsWithoutPeopleTeleportedFromThem() {
        return null;
    }
}
