package org.softuni.mostwanted.parser.implementations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.softuni.mostwanted.parser.interfaces.Parser;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;


public class JSONParser implements Parser {
    @Override
    public <T> T read(Class<T> objectClass, String fileContent) throws IOException, JAXBException {
        Gson gson = new Gson();
        T result = gson.fromJson(fileContent,objectClass);
        return result;
    }

    @Override
    public <T> String write(T object) throws IOException, JAXBException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(object);
        return result;
    }
}
