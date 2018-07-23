package app.retake.controllers;

import app.retake.domain.dto.VetWrapperXMLImportDTO;
import app.retake.domain.dto.VetXMLImportDTO;
import app.retake.parser.JSONParser;
import app.retake.parser.XMLParser;
import app.retake.parser.interfaces.Parser;
import app.retake.services.api.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class VetController {

    @Autowired
    private VetService vetService;

    public String importDataFromXML(String xmlContent) throws IOException, JAXBException {
        Parser xmlParser=new XMLParser();
        VetWrapperXMLImportDTO vets = xmlParser.read(VetWrapperXMLImportDTO.class,xmlContent);
        List<String> toReturn=new LinkedList<>();
        for (VetXMLImportDTO vet : vets.getVets()) {
            try{
                this.vetService.create(vet);
                toReturn.add(String.format("Record %s successfully imported.",vet.getName()));
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
