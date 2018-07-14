package com.masdefect.controller;

import com.masdefect.domain.dto.json.SolarSystemImportJSONDto;
import com.masdefect.domain.dto.json.StarImportJSONDto;
import com.masdefect.parser.JSONParser;
import com.masdefect.parser.interfaces.FileParser;
import com.masdefect.service.StarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class StarsController {
    @Autowired
    private StarService starService;

    public String importDataFromJSON(String fileContent) throws IOException, JAXBException {
        FileParser jsonParser=new JSONParser();
        StarImportJSONDto[] stars = jsonParser.read(StarImportJSONDto[].class,fileContent);
        List<String> toReturn=new LinkedList<>();
        for (StarImportJSONDto star : stars) {
            try{
                this.starService.create(star);
                toReturn.add(String.format("Successfully imported Star %s.",star.getName()));
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
