package com.masdefect.controller;

import com.masdefect.domain.dto.json.AnomalyImportJSONDto;
import com.masdefect.domain.dto.xml.AnomaliesXMLDto;
import com.masdefect.domain.dto.xml.AnomalyXMLDto;
import com.masdefect.parser.JSONParser;
import com.masdefect.parser.XMLParser;
import com.masdefect.parser.interfaces.FileParser;
import com.masdefect.service.AnomalyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class AnomalyController {

    @Autowired
    private AnomalyService anomalyService;

    public String importDataFromJSON(String fileContent) throws IOException, JAXBException {
        FileParser jsonParser=new JSONParser();
        AnomalyImportJSONDto[] anomalys = jsonParser.read(AnomalyImportJSONDto[].class,fileContent);
        List<String> toReturn=new LinkedList<>();
        for (AnomalyImportJSONDto anomaly : anomalys) {
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

    public String importDataFromXML(String fileContent) throws IOException, JAXBException {
        //impl
        FileParser xmlParser=new XMLParser();
        AnomaliesXMLDto anomaliesXMLDto=xmlParser.read(AnomaliesXMLDto.class,fileContent);
        List<String> toReturn=new LinkedList<>();
        for (AnomalyXMLDto anomalyXMLDto : anomaliesXMLDto.getAnomalies()) {
            try{
                this.anomalyService.create(anomalyXMLDto);
                toReturn.add(String.format("Successfully imported data."));
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

    public String findAnomalyWithMostVictims() {
       return null;
    }

    public String exportAnomaliesOrdered() throws IOException, JAXBException {
         FileParser xmlParser=new XMLParser();
        return xmlParser.write(this.anomalyService.finaAllAnomalies());
    }
}
