package org.softuni.mostwanted.services.implementations;

import org.softuni.mostwanted.domain.dtos.exports.json.RacingCarsExportJSONDto;
import org.softuni.mostwanted.domain.dtos.exports.xml.MostWantedEntryExportXMLDto;
import org.softuni.mostwanted.domain.dtos.exports.xml.MostWantedEntryWrapperExportXMLDto;
import org.softuni.mostwanted.domain.dtos.exports.xml.MostWantedRacerExportXMLDto;
import org.softuni.mostwanted.domain.dtos.exports.xml.MostWantedWrapperExportXMLDto;
import org.softuni.mostwanted.domain.dtos.imports.json.RacerImportJSONDto;
import org.softuni.mostwanted.domain.entities.Car;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.io.impl.FileIOImpl;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.implementations.JSONParser;
import org.softuni.mostwanted.parser.implementations.XMLParser;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.CarRepository;
import org.softuni.mostwanted.repositories.RaceEntryRepository;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.softuni.mostwanted.services.interfaces.RacerServices;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class RacerServicesImp implements RacerServices {

    private final RacerRepository racerRepository;
    private final CarRepository carRepository;
    private final TownRepository townRepository;
    private final RaceEntryRepository raceEntryRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    public RacerServicesImp(RacerRepository racerRepository, CarRepository carRepository, TownRepository townRepository, RaceEntryRepository raceEntryRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.racerRepository = racerRepository;
        this.carRepository = carRepository;
        this.townRepository = townRepository;
        this.raceEntryRepository = raceEntryRepository;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.modelParser = modelParser;
        this.fileIO = fileIO;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean save(Racer racer) {
        this.racerRepository.save(racer);
        return true;
    }

    @Override
    public void seedDatabase() {
        if(this.racerRepository.findAll().size()==0){
            RacerImportJSONDto[] racerImportJSONDto = null;
            try {
                racerImportJSONDto = this.jsonParser.read(RacerImportJSONDto[].class,this.fileIO.read("files\\json\\input\\racers.json"));
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }

            Arrays.stream(racerImportJSONDto).forEach(x->{
                Town town = this.townRepository.findTownByName(x.getHomeTown());
                if(this.validationUtil.isValid(x) && town!=null){
                    Racer racer = this.modelParser.convert(x,Racer.class);
                    racer.setHomeTown(town);
                    this.save(racer);
                    System.out.println(String.format("Succesfully imported District – %s.",x.getName()));
                }else{
                    System.out.println("Error: Incorrect Data!");
                }
            });
        }
    }

    @Override
    public void exportMostWanted() {
        List<Racer> racers = this.racerRepository.findAll();
        MostWantedWrapperExportXMLDto mostWantedWrapperExportXMLDto = new MostWantedWrapperExportXMLDto();
        List<MostWantedRacerExportXMLDto> mostWantedRacerExportXMLDtos = new ArrayList<>();
        AtomicLong older = new AtomicLong();
        racers.stream().forEach(x->{
            MostWantedRacerExportXMLDto mostWantedRacerExportXMLDto = new MostWantedRacerExportXMLDto();
            mostWantedRacerExportXMLDto.setName(x.getName());
            MostWantedEntryWrapperExportXMLDto mostWantedEntryWrapperExportXMLDto = new MostWantedEntryWrapperExportXMLDto();
            List<MostWantedEntryExportXMLDto> mostWantedEntryExportXMLDtos = new ArrayList<>();
            this.raceEntryRepository.findAllByRacer(x)
                    .stream()
                    .sorted((x1,x2)->Double.compare(x1.getFinishTime(),x2.getFinishTime()))
                    .forEach(z->{
                        MostWantedEntryExportXMLDto mostWantedEntryExportXMLDto = new MostWantedEntryExportXMLDto();
                        mostWantedEntryExportXMLDto.setCar(String.format("%s %s @ %d",z.getCar().getBrand(),z.getCar().getModel(),z.getCar().getYearOfProduction()));
                        mostWantedEntryExportXMLDto.setFinishTime(z.getFinishTime());
                        mostWantedEntryExportXMLDtos.add(mostWantedEntryExportXMLDto);
                    });
            mostWantedEntryWrapperExportXMLDto.setMostWantedEntryExportXMLDtos(mostWantedEntryExportXMLDtos);
            mostWantedRacerExportXMLDto.setMostWantedEntryWrapperExportXMLDto(mostWantedEntryWrapperExportXMLDto);
            if(mostWantedEntryExportXMLDtos.size() > older.get()){
                older.set(mostWantedEntryExportXMLDtos.size());
                mostWantedRacerExportXMLDtos.clear();
                mostWantedRacerExportXMLDtos.add(mostWantedRacerExportXMLDto);
            }
        });
        mostWantedWrapperExportXMLDto.setMostWantedRacerExportXMLDtos(mostWantedRacerExportXMLDtos);
        try {
            String result = this.xmlParser.write(mostWantedWrapperExportXMLDto);
            this.fileIO.write(result,"files\\xml\\output\\most-wanted.xml");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void exportRacingCars() {
        List<RacingCarsExportJSONDto> racingCarsExportJSONDtos = new ArrayList<>();
        this.racerRepository.findAll().stream().forEach(x->{
            List<Car> cars = this.carRepository.findAllByRacer(x);
            RacingCarsExportJSONDto racingCarsExportJSONDto = new RacingCarsExportJSONDto();
            racingCarsExportJSONDto.setName(x.getName());
            if(x.getAge()>0){
                racingCarsExportJSONDto.setAge(x.getAge());
            }else{
                racingCarsExportJSONDto.setAge(null);
            }
            String[] carsFormated = new String[x.getCars().size()];
            final int[] counter = {0};
            x.getCars().stream().forEach(z->{
                carsFormated[counter[0]]=String.format("%s %s %s",z.getBrand(),z.getModel(),z.getYearOfProduction());
                counter[0]++;
            });
            racingCarsExportJSONDto.setCars(carsFormated);
            racingCarsExportJSONDtos.add(racingCarsExportJSONDto);
        });
        List<RacingCarsExportJSONDto> ordered = racingCarsExportJSONDtos.stream().sorted((x1,x2)->{
            if(x1.getCars().length!=x2.getCars().length){
                return Integer.compare(x2.getCars().length,x1.getCars().length);
            }else{
                return x1.getName().compareTo(x2.getName());
            }
        }).collect(Collectors.toList());

        try {
            this.fileIO.write(this.jsonParser.write(ordered),"files\\json\\output\\racingCars.json");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
