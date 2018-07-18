package app.exam.controller;

import app.exam.domain.dto.json.EmployeeJSONImportDTO;
import app.exam.domain.entities.Employee;
import app.exam.domain.entities.Position;
import app.exam.parser.JSONParser;
import app.exam.parser.interfaces.ModelParser;
import app.exam.parser.interfaces.Parser;
import app.exam.repository.PositionRepository;
import app.exam.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    public String importDataFromJSON(String jsonContent) throws IOException, JAXBException {
        Parser jsonParser=new JSONParser();
        EmployeeJSONImportDTO[] employees = jsonParser.read(EmployeeJSONImportDTO[].class,jsonContent);
        List<String> toReturn=new LinkedList<>();
        for (EmployeeJSONImportDTO employee : employees) {
            try{
                this.employeeService.create(employee);
                toReturn.add(String.format("Record %s successfully imported. ",employee.getName()));
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
