package app.exam.parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;
import app.exam.parser.interfaces.Parser;

import javax.xml.bind.JAXBException;
import java.io.FileReader;
import java.io.IOException;

@Component(value = "JSONParser")
public class JSONParser implements Parser {

    @Override
    public <T> T read(Class<T> objectClass, String fileContent) throws IOException, JAXBException {
        Gson gson=new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        T toReturn= gson.fromJson(new FileReader(fileContent),objectClass);
        return toReturn;
    }

    @Override
    public <T> String write(T object) throws IOException, JAXBException {
        Gson gson=new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        String toReturn =  gson.toJson(object);
        return toReturn;
    }
}
