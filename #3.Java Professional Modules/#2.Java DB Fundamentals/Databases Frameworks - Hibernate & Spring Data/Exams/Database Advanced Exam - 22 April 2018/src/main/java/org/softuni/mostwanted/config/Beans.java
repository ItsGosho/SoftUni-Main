package org.softuni.mostwanted.config;

import org.softuni.mostwanted.io.impl.FileIOImpl;
import org.softuni.mostwanted.parser.ValidationUtil;
import org.softuni.mostwanted.parser.implementations.JSONParser;
import org.softuni.mostwanted.parser.implementations.ModelParserImp;
import org.softuni.mostwanted.parser.implementations.XMLParser;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    private JSONParser jsonParser;
    private XMLParser xmlParser;
    private ModelParser modelParser;
    private FileIOImpl fileIO;
    private ValidationUtil validationUtil;

    @Bean
    public JSONParser getJsonParser() {
        return new JSONParser();
    }
    @Bean
    public XMLParser getXmlParser() {
        return new XMLParser();
    }
    @Bean
    public ModelParser getModelParser() {
        return new ModelParserImp();
    }
    @Bean
    public FileIOImpl getFileIO() {
        return new FileIOImpl();
    }
    @Bean
    public ValidationUtil getValidationUtil() {
        return new ValidationUtil();
    }
}
