package app;

import app.dto.PersonDto;
import app.gson_parser.GsonParser;
import app.models.Person;
import app.services.PersonService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private PersonService personService;

    @Autowired
    public ConsoleRunner(PersonService personService) {
       this.personService=personService;
    }

    @Override
    public void run(String... strings) throws Exception {
        ModelMapper modelMapper=new ModelMapper();
        PersonDto personDto=GsonParser.parsePersonDto("C:\\Users\\Gosho\\Desktop\\DB\\#13.JSON Processing Lab\\src\\main\\resources\\person.json");
        Person person=modelMapper.map(personDto,Person.class);
        this.personService.create(person);
    }
}
