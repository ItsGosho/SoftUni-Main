package org.softuni.mostwanted.services.implementations;

import org.softuni.mostwanted.domain.dtos.imports.json.DistrictImportJSONDto;
import org.softuni.mostwanted.domain.entities.District;
import org.softuni.mostwanted.domain.entities.Town;
import org.softuni.mostwanted.io.impl.FileIOImpl;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.implementations.JSONParser;
import org.softuni.mostwanted.parser.implementations.XMLParser;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.softuni.mostwanted.repositories.DistrictRepository;
import org.softuni.mostwanted.repositories.TownRepository;
import org.softuni.mostwanted.services.interfaces.DistrictServices;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Arrays;

@Service
public class DistrictServicesImp implements DistrictServices {

    private final DistrictRepository districtRepository;
    private final TownRepository townRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    public DistrictServicesImp(DistrictRepository districtRepository, TownRepository townRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.districtRepository = districtRepository;
        this.townRepository = townRepository;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.modelParser = modelParser;
        this.fileIO = fileIO;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean save(District district) {
        this.districtRepository.save(district);
        return true;
    }

    @Override
    public void seedDatabase() {
        if(this.districtRepository.findAll().size()==0){
            DistrictImportJSONDto[] districtImportJSONDto = null;

            try {
                districtImportJSONDto = this.jsonParser.read(DistrictImportJSONDto[].class,this.fileIO.read("files\\json\\input\\districts.json"));
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }

            Arrays.stream(districtImportJSONDto).forEach(x->{
                Town town = this.townRepository.findTownByName(x.getTownName());
                if(this.validationUtil.isValid(x) && town!=null && this.districtRepository.findDistinctByName(x.getName())==null){
                    District district = this.modelParser.convert(x,District.class);
                    district.setTown(town);
                    this.save(district);
                    System.out.println(String.format("Succesfully imported District – %s.",x.getName()));
                }else{
                    System.out.println("Error: Incorrect Data!");
                }
            });
        }
    }
}
