package itsgosho.config;

import itsgosho.io.impl.FileIOImpl;
import itsgosho.parser.ValidationUtil;
import itsgosho.parser.implementations.JSONParser;
import itsgosho.parser.implementations.ModelParserImp;
import itsgosho.parser.implementations.XMLParser;
import itsgosho.parser.interfaces.ModelParser;
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
