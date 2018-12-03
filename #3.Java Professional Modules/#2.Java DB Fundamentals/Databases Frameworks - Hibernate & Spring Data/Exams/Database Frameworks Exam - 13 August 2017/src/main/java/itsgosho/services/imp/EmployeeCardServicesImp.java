package itsgosho.services.imp;

import itsgosho.domain.dtos.exports.json.FreeCardsExportJSONDto;
import itsgosho.domain.dtos.imports.json.EmployeeCardImportJSONDto;
import itsgosho.domain.entities.EmployeeCard;
import itsgosho.io.impl.FileIOImpl;
import itsgosho.parser.ValidationUtil;
import itsgosho.parser.implementations.JSONParser;
import itsgosho.parser.implementations.XMLParser;
import itsgosho.parser.interfaces.ModelParser;
import itsgosho.repositories.EmployeeCardRepository;
import itsgosho.services.inter.EmployeeCardServices;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeCardServicesImp implements EmployeeCardServices {

    private final EmployeeCardRepository employeeCardRepository;
    private final JSONParser jsonParser;
    private final XMLParser xmlParser;
    private final ModelParser modelParser;
    private final FileIOImpl fileIO;
    private final ValidationUtil validationUtil;

    public EmployeeCardServicesImp(EmployeeCardRepository employeeCardRepository, JSONParser jsonParser, XMLParser xmlParser, ModelParser modelParser, FileIOImpl fileIO, ValidationUtil validationUtil) {
        this.employeeCardRepository = employeeCardRepository;
        this.jsonParser = jsonParser;
        this.xmlParser = xmlParser;
        this.modelParser = modelParser;
        this.fileIO = fileIO;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean save(EmployeeCard employeeCard) {
        this.employeeCardRepository.save(employeeCard);
        return true;
    }

    @Override
    public void seedDatabase() {
        if(this.employeeCardRepository.findAll().size()==0){
            EmployeeCardImportJSONDto[] employeeCardImportJSONDtos = null;

            try {
                employeeCardImportJSONDtos = this.jsonParser.read(EmployeeCardImportJSONDto[].class,this.fileIO.read("json\\input\\employee_cards.json"));
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }

            Arrays.stream(employeeCardImportJSONDtos).forEach(x->{
                if(this.validationUtil.isValid(x) && this.employeeCardRepository.findByNumber(x.getNumber())==null){
                    EmployeeCard employeeCard = this.modelParser.convert(x,EmployeeCard.class);
                    this.save(employeeCard);
                    System.out.println(String.format("Successfully imported Employee Card %s.",employeeCard.getNumber()));
                }else{
                    System.out.println("Error: Invalid data.");
                }
            });
        }
    }

    @Override
    public void exportFreeCards() {
       List<FreeCardsExportJSONDto> employeeCards = this.employeeCardRepository.findAll().stream()
               .filter(x->x.getEmployee()==null)
               .sorted((x1,x2)->Long.compare(x1.getId(),x2.getId()))
               .map(x->this.modelParser.convert(x,FreeCardsExportJSONDto.class))
               .collect(Collectors.toList());
       FreeCardsExportJSONDto[] freeCardsExportJSONDto = new FreeCardsExportJSONDto[employeeCards.size()];
       freeCardsExportJSONDto = employeeCards.toArray(freeCardsExportJSONDto);
        try {
            String res = this.jsonParser.write(freeCardsExportJSONDto);
            this.fileIO.write(res,"json\\output\\free_cards.json");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
