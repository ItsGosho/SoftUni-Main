package app.gson_parser;

import app.dto.PersonDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GsonParser {

    private static Gson gsonInitialised(){
        Gson gson=new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        return gson;
    }

    public static PersonDto parsePersonDto(String jsonPath) throws FileNotFoundException {
        PersonDto personDto=gsonInitialised().fromJson(new FileReader(jsonPath), PersonDto.class);
        return personDto;
    }
}
