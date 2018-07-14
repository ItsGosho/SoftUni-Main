package com.masdefect.services_impl;

import com.masdefect.domain.dto.json.StarImportJSONDto;
import com.masdefect.domain.entities.SolarSystem;
import com.masdefect.domain.entities.Star;
import com.masdefect.parser.interfaces.ModelParser;
import com.masdefect.repository.SolarSystemRepository;
import com.masdefect.repository.StarRepository;
import com.masdefect.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;

@Service
public class StarSerImpl implements StarService {

    @Autowired
    private StarRepository starRepository;
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private SolarSystemRepository solarSystemRepository;

    @Override
    public void create(StarImportJSONDto starImportJSONDto) {
        Star star=this.modelParser.convert(starImportJSONDto,Star.class);
        SolarSystem solarSystem = this.solarSystemRepository.findSolarSystemByName(starImportJSONDto.getSolarSystem());
        star.setSolarSystem(solarSystem);
        this.starRepository.save(star);
    }
}
