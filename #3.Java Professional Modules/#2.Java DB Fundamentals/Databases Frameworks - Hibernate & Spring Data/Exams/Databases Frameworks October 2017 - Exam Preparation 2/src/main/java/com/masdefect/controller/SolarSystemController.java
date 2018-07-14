package com.masdefect.controller;

import com.masdefect.domain.dto.json.SolarSystemImportJSONDto;
import com.masdefect.parser.JSONParser;
import com.masdefect.parser.interfaces.FileParser;
import com.masdefect.service.SolarSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class SolarSystemController {

    @Autowired
    private SolarSystemService solarSystemService;

    public String importDataFromJSON(String fileContent) throws IOException, JAXBException {
        FileParser jsonParser=new JSONParser();
        SolarSystemImportJSONDto[] solarSystems = jsonParser.read(SolarSystemImportJSONDto[].class,fileContent);
        List<String> toReturn=new LinkedList<>();
        for (SolarSystemImportJSONDto system : solarSystems) {
            try{
               this.solarSystemService.create(system);
               toReturn.add(String.format("Successfully imported Solar System %s.",system.getName()));
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
