package com.masdefect.controller;

import com.masdefect.domain.dto.json.PersonImportJSONDto;
import com.masdefect.parser.JSONParser;
import com.masdefect.parser.interfaces.FileParser;
import com.masdefect.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class PersonsController {

    @Autowired
    private PersonService personService;

    public String importDataFromJSON(String fileContent) throws IOException, JAXBException {
        FileParser jsonParser=new JSONParser();
        PersonImportJSONDto[] persons = jsonParser.read(PersonImportJSONDto[].class,fileContent);
        List<String> toReturn=new LinkedList<>();
        for (PersonImportJSONDto person : persons) {
            try{
                this.personService.create(person);
                toReturn.add(String.format("Successfully imported Person %s.",person.getName()));
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
