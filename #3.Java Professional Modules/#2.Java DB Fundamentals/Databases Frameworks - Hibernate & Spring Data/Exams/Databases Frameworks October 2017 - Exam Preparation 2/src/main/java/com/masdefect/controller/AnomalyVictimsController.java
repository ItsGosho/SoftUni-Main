package com.masdefect.controller;

import com.masdefect.domain.dto.json.AnomalyImportJSONDto;
import com.masdefect.domain.dto.json.AnomalyVictimsJSONDto;
import com.masdefect.parser.JSONParser;
import com.masdefect.parser.interfaces.FileParser;
import com.masdefect.service.AnomalyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class AnomalyVictimsController {

    @Autowired
    private AnomalyService anomalyService;

    public String importDataFromJSON(String fileContent) throws IOException, JAXBException {
        FileParser jsonParser=new JSONParser();
        AnomalyVictimsJSONDto[] anomalyVictims = jsonParser.read(AnomalyVictimsJSONDto[].class,fileContent);
        List<String> toReturn=new LinkedList<>();
        for (AnomalyVictimsJSONDto anomaly : anomalyVictims) {
            try{
                this.anomalyService.create(anomaly);
                toReturn.add(String.format("Successfully imported anomaly."));
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
