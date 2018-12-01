package org.softuni.mostwanted.services.implementations;

import org.softuni.mostwanted.domain.dtos.imports.json.CarImportJSONDto;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.io.impl.FileIOImpl;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.implementations.JSONParser;
import org.softuni.mostwanted.parser.implementations.XMLParser;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.services.interfaces.CarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class CarServicesImp implements CarServices {

    private final CarRepository carRepository;
    private final RacerRepository racerRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    @Autowired
    public CarServicesImp(CarRepository carRepository, RacerRepository racerRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.modelParser = modelParser;
        this.fileIO = fileIO;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean save(Car car) {
        this.carRepository.save(car);
        return true;
    }

    @Override
    public void seedDatabase() {
         if(this.carRepository.findAll().size()==0){
             CarImportJSONDto[] carImportJSONDtos = null;

             try {
                 carImportJSONDtos = this.jsonParser.read(CarImportJSONDto[].class,this.fileIO.read("files\\json\\input\\cars.json"));
             } catch (IOException | JAXBException e) {
                 e.printStackTrace();
             }

             Arrays.stream(carImportJSONDtos).forEach(x->{
                 Racer racer = this.racerRepository.findRacerByName(x.getRacerName());
                 if(this.validationUtil.isValid(x) && racer!=null){
                       Car car = this.modelParser.convert(x, Car.class);
                       car.setRacer(racer);
                       this.carRepository.save(car);
                      System.out.println(String.format("Succesfully imported Car - %s %s @ %d.",x.getBrand(),x.getModel(),x.getYearOfProduction()));
                 }else{
                     System.out.println("Error: Incorrect Data!");
                 }
             });
         }
    }
}
