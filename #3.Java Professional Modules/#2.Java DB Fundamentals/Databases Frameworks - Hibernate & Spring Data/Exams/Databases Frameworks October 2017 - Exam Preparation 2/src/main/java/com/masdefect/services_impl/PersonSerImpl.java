package com.masdefect.services_impl;

import com.masdefect.domain.dto.json.PersonExportJSONDto;
import com.masdefect.domain.dto.json.PersonImportJSONDto;
import com.masdefect.domain.entities.Person;
import com.masdefect.domain.entities.Planet;
import com.masdefect.parser.interfaces.ModelParser;
import com.masdefect.repository.PersonRepository;
import com.masdefect.repository.PlanetRepository;
import com.masdefect.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonSerImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public void create(PersonImportJSONDto personImportJSONDto) {
        Person person=this.modelParser.convert(personImportJSONDto,Person.class);
        Planet planet=this.planetRepository.findPlanetByName(personImportJSONDto.getHomePlanet());
        person.setHomePlanet(planet);
        this.personRepository.save(person);
    }

    @Override
    public List<PersonExportJSONDto> findInnocentPersons() {
        return null;
    }
}
