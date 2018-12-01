package org.softuni.mostwanted.services.implementations;

import org.softuni.mostwanted.domain.dtos.imports.xml.RaceImportWrapperXMLDto;
import org.softuni.mostwanted.domain.entities.District;
import org.softuni.mostwanted.domain.entities.Race;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.io.impl.FileIOImpl;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.implementations.JSONParser;
import org.softuni.mostwanted.parser.implementations.XMLParser;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RaceRepository;
import org.softuni.mostwanted.services.interfaces.RaceServices;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class RaceServicesImp implements RaceServices {

    private final RaceRepository raceRepository;
    private final RaceEntryRepository raceEntryRepository;
    private final DistrictRepository districtRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    public RaceServicesImp(RaceRepository raceRepository, RaceEntryRepository raceEntryRepository, DistrictRepository districtRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.raceRepository = raceRepository;
        this.raceEntryRepository = raceEntryRepository;
        this.districtRepository = districtRepository;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.modelParser = modelParser;
        this.fileIO = fileIO;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean save(Race race) {
        this.raceRepository.save(race);
        return true;
    }

    @Override
    public void seedDatabase() {
        if(this.raceRepository.findAll().size()==0){
            RaceImportWrapperXMLDto raceImportWrapperXMLDto = null;

            try {
                raceImportWrapperXMLDto = this.xmlParser.read(RaceImportWrapperXMLDto.class,this.fileIO.read("files\\xml\\input\\races.xml"));
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }

            raceImportWrapperXMLDto.getRaceImportXMLDtos().stream().forEach(x->{
                District district = this.districtRepository.findDistinctByName(x.getDistrictName());
                if(this.validationUtil.isValid(x) && district!=null){
                    Race race = this.modelParser.convert(x,Race.class);
                    race.setDistrict(district);
                    Set<RaceEntry> raceEntries = new HashSet<>();
                    x.getEntryImportWrapperXMLDto().getEntryImportXMLDtos().stream().forEach(z->{
                          RaceEntry raceEntry = this.raceEntryRepository.findOne(z.getId());
                          if(raceEntry!=null){
                               raceEntries.add(raceEntry);
                          }
                    });
                    race.setEntries(raceEntries);
                    this.save(race);
                    System.out.println(String.format("Succesfully imported Race – %s.",race.getId()));
                }else{
                    System.out.println("Error: Incorrect Data!");
                }
            });
        }
    }
}
