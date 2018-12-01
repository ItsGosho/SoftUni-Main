package org.softuni.mostwanted.services.implementations;

import org.softuni.mostwanted.domain.dtos.imports.xml.RaceEntryImportWrapperXMLDto;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.io.impl.FileIOImpl;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.implementations.JSONParser;
import org.softuni.mostwanted.parser.implementations.XMLParser;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.services.interfaces.RaceEntryServices;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class RaceEntryServicesImp implements RaceEntryServices {

    private final RaceEntryRepository raceEntryRepository;
    private final CarRepository carRepository;
    private final RacerRepository racerRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    public RaceEntryServicesImp(RaceEntryRepository raceEntryRepository, CarRepository carRepository, RacerRepository racerRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.raceEntryRepository = raceEntryRepository;
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.modelParser = modelParser;
        this.fileIO = fileIO;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean save(RaceEntry raceEntry) {
        this.raceEntryRepository.save(raceEntry);
        return true;
    }

    @Override
    public void seedDatabase() {
        if (this.raceEntryRepository.findAll().size() == 0) {
            RaceEntryImportWrapperXMLDto raceEntryImportWrapperXMLDto = null;

            try {
                raceEntryImportWrapperXMLDto = this.xmlParser.read(RaceEntryImportWrapperXMLDto.class,this.fileIO.read("files\\xml\\input\\race-entries.xml"));
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }

           raceEntryImportWrapperXMLDto.getRaceEntryImportXMLDtos().stream().forEach(x->{
               Car car = this.carRepository.findOne(x.getCarId());
               Racer racer = this.racerRepository.findRacerByName(x.getRacerName());

               if(this.validationUtil.isValid(x) && car!=null && racer!=null){
                   RaceEntry raceEntry = this.modelParser.convert(x,RaceEntry.class);
                   raceEntry.setCar(car);
                   raceEntry.setRacer(racer);
                   this.save(raceEntry);
                   System.out.println(String.format("Succesfully imported RaceEntry – %s.",raceEntry.getId()));
               }else{
                   System.out.println("Error: Incorrect Data!");
               }
           });
        }
    }
}
