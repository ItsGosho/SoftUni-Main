package app.retake.controllers;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.domain.dto.AnimalsJSONExportDTO;
import app.retake.parser.JSONParser;
import app.retake.parser.interfaces.ModelParser;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.AnimalAidService;
import app.retake.services.api.AnimalService;
import com.google.gson.annotations.JsonAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    public String importDataFromJSON(String jsonContent) throws IOException, JAXBException {
        Parser jsonParser=new JSONParser();
        AnimalJSONImportDTO[] animal = jsonParser.read(AnimalJSONImportDTO[].class,jsonContent);
        List<String> toReturn=new LinkedList<>();
        for (AnimalJSONImportDTO a : animal) {
            try{
                this.animalService.create(a);
                toReturn.add(String.format("Record %s Passport №: %s successfully imported.",a.getName(),a.getPassportJSONImportDTO().getSerialNumber()));
            }catch (Exception ex){
                toReturn.add(String.format("Error: Invalid data."));
            }
        }
        String finalRet="";
        for (String s : toReturn) {
            finalRet+=String.format("%s%n",s);
        }
        return finalRet;
    }

    public String exportAnimalsByOwnerPhoneNumber(String phoneNumber) throws IOException, JAXBException {
        Parser modelParser= new JSONParser();
        return modelParser.write(this.animalService.findByOwnerPhoneNumber(phoneNumber));
    }
}
