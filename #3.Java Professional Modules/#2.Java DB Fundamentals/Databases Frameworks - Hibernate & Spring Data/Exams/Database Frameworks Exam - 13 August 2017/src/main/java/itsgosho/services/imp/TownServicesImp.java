package itsgosho.services.imp;

import itsgosho.domain.dtos.exports.xml.TownExportXMLDto;
import itsgosho.domain.dtos.exports.xml.TownsExportWrapperXMLDto;
import itsgosho.domain.dtos.imports.json.TownImportJSONDto;
import itsgosho.domain.entities.Product;
import itsgosho.domain.entities.Town;
import itsgosho.io.impl.FileIOImpl;
import itsgosho.parser.ValidationUtil;
import itsgosho.parser.implementations.JSONParser;
import itsgosho.parser.implementations.XMLParser;
import itsgosho.parser.interfaces.ModelParser;
import itsgosho.repositories.ProductRepository;
import itsgosho.repositories.TownRepository;
import itsgosho.services.inter.TownServices;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServicesImp implements TownServices {

    private final TownRepository townRepository;
    private final ProductRepository productRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    public TownServicesImp(TownRepository townRepository, ProductRepository productRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.productRepository = productRepository;
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
            TownImportJSONDto[] townImportJSONDtos=null;
            try {
                townImportJSONDtos = this.jsonParser.read(TownImportJSONDto[].class,this.fileIO.read("json\\input\\towns.json"));
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
            Arrays.stream(townImportJSONDtos).forEach(x->{
                 if(this.validationUtil.isValid(x)){
                     Town town = this.modelParser.convert(x,Town.class);
                     this.save(town);
                     System.out.println(String.format("Successfully imported Town %s.",town.getName()));
                 }else{
                     System.out.println("Error: Invalid data.");
                 }
            });
        }
    }

    @Override
    public void exportTowns() {
        TownsExportWrapperXMLDto townsExportWrapperXMLDto = new TownsExportWrapperXMLDto();
        List<TownExportXMLDto> townExportXMLDtoList = new ArrayList<>();

        this.townRepository.exportTowns().stream().forEach(x->{
            Object[] objects = (Object[]) x;
            TownExportXMLDto town = this.modelParser.convert(objects[0],TownExportXMLDto.class);
            town.setClients((Long) objects[1]);
            townExportXMLDtoList.add(town);
        });
        townsExportWrapperXMLDto.setTownExportXMLDtos(townExportXMLDtoList.stream().sorted((x1,x2)->Long.compare(x2.getClients(),x1.getClients())).collect(Collectors.toList()));
        String res = null;
        try {
            res = this.xmlParser.write(townsExportWrapperXMLDto);
            this.fileIO.write(res,"xml\\output\\towns.xml");
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
    }
}
