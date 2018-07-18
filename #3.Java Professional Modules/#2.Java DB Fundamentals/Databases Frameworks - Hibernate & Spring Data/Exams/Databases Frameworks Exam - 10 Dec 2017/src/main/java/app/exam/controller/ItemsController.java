package app.exam.controller;

import app.exam.domain.dto.json.ItemJSONImportDTO;
import app.exam.parser.JSONParser;
import app.exam.parser.interfaces.Parser;
import app.exam.service.api.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    public String importDataFromJSON(String jsonContent) throws IOException, JAXBException {
        Parser jsonParser=new JSONParser();
        ItemJSONImportDTO[] items = jsonParser.read(ItemJSONImportDTO[].class,jsonContent);
        List<String> toReturn=new LinkedList<>();
        for (ItemJSONImportDTO item : items) {
            try{
                this.itemsService.create(item);
                toReturn.add(String.format("Record %s successfully imported. ",item.getName()));
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
