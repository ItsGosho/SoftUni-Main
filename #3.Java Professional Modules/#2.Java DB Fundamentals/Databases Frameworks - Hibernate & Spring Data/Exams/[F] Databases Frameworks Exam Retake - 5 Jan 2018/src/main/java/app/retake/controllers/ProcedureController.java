package app.retake.controllers;

import app.retake.domain.dto.ProcedureWrapperXMLImportDTO;
import app.retake.domain.dto.ProcedureXMLImportDTO;
import app.retake.domain.models.AnimalAid;
import app.retake.domain.models.Procedure;
import app.retake.parser.XMLParser;
import app.retake.parser.interfaces.Parser;
import app.retake.repositories.ProcedureRepository;
import app.retake.services.api.ProcedureService;
import app.retake.services.impl.ProcedureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ProcedureController {

    @Autowired
    private ProcedureService procedureService;
    @Autowired
    private ProcedureRepository procedureRepository;

    public String importDataFromXML(String xmlContent) throws IOException, JAXBException {
        Parser xmlParser=new XMLParser();
        ProcedureWrapperXMLImportDTO procedures = xmlParser.read(ProcedureWrapperXMLImportDTO.class,xmlContent);
        List<String> toReturn=new LinkedList<>();
        for (ProcedureXMLImportDTO procedure : procedures.getProcedures()) {
            try{
                this.procedureService.create(procedure);
                toReturn.add(String.format("Record successfully imported."));
            }catch (Exception ex){
                //System.out.println(ex.getMessage());
                toReturn.add(String.format("Error: Invalid data."));
            }
        }
        String finalRet="";
        for (String s : toReturn) {
            finalRet+=String.format("%s%n",s);
        }
        return finalRet;
    }

    public String exportProcedures() throws IOException, JAXBException {
        Parser parser=new XMLParser();
        return parser.write(this.procedureService.exportProcedures());
    }
}
