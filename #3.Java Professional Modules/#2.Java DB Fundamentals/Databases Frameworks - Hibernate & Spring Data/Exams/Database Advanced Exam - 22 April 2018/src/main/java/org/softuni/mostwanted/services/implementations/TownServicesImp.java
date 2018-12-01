package org.softuni.mostwanted.services.implementations;

import org.softuni.mostwanted.domain.dtos.exports.json.RacingTownsExportJSONDto;
import org.softuni.mostwanted.domain.dtos.imports.json.TownImportJSONDto;
import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.io.impl.FileIOImpl;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.implementations.JSONParser;
import org.softuni.mostwanted.parser.implementations.XMLParser;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.RacerRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.softuni.mostwanted.services.interfaces.TownServices;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServicesImp implements TownServices {

    private final TownRepository townRepository;
    private final RacerRepository racerRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    public TownServicesImp(TownRepository townRepository, RacerRepository racerRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.racerRepository = racerRepository;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.modelParser = modelParser;
        this.fileIO = fileIO;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean save(Town town) {
        this.townRepository.save(town);
        return true;
    }

    @Override
    public void seedDatabase() {
        if(this.townRepository.findAll().size()==0){
            TownImportJSONDto[] townImportJSONDto = null;
            try {
                townImportJSONDto = this.jsonParser.read(TownImportJSONDto[].class,this.fileIO.read("files\\json\\input\\towns.json"));
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }

            Arrays.stream(townImportJSONDto).forEach(x->{
                if(this.validationUtil.isValid(x)){
                    Town town = this.modelParser.convert(x,Town.class);
                    this.save(town);
                    System.out.println(String.format("Succesfully imported Town – %s.",x.getName()));
                }else{
                    System.out.println("Error: Incorrect Data!");
                }
            });
        }
    }

    @Override
    public void exportRacingTowns() {
        List<RacingTownsExportJSONDto> racingTownsExportJSONDtos = new ArrayList<>();
        this.townRepository.findAll().forEach(x->{
            RacingTownsExportJSONDto racingTownsExportJSONDto = new RacingTownsExportJSONDto();
            racingTownsExportJSONDto.setName(x.getName());
            racingTownsExportJSONDto.setRacers(this.racerRepository.findAllByHomeTown(x).size());
            racingTownsExportJSONDtos.add(racingTownsExportJSONDto);
        });
        List<RacingTownsExportJSONDto> result = racingTownsExportJSONDtos
                .stream()
                .sorted((x1,x2)-> Integer.compare(x2.getRacers(),x1.getRacers()))
                .collect(Collectors.toList());
        try {
            String output = this.jsonParser.write(result);
            this.fileIO.write(output,"files\\json\\output\\racingTowns.json");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
