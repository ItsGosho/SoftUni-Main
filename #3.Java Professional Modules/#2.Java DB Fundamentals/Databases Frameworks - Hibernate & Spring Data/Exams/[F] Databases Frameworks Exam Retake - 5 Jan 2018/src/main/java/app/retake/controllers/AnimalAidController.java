package app.retake.controllers;

import app.retake.domain.dto.AnimalAidJSONImportDTO;
import app.retake.parser.JSONParser;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.AnimalAidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class AnimalAidController {

    @Autowired
    private AnimalAidService animalAidService;

    public String importDataFromJSON(String jsonContent) throws IOException, JAXBException {
        Parser jsonParser=new JSONParser();
        AnimalAidJSONImportDTO[] animalAids = jsonParser.read(AnimalAidJSONImportDTO[].class,jsonContent);
        List<String> toReturn=new LinkedList<>();
        for (AnimalAidJSONImportDTO aid : animalAids) {
            try{
                this.animalAidService.create(aid);
                toReturn.add(String.format("Record %s successfully imported. ",aid.getName()));
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
}
