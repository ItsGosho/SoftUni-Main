package mostwanted.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mostwanted.util.impl.FileUtilImp;
import mostwanted.util.impl.ValidationUtilImp;
import mostwanted.util.impl.XmlParserImp;
import mostwanted.util.inter.FileUtil;
import mostwanted.util.inter.ValidationUtil;
import mostwanted.util.inter.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public FileUtil fileUtil() {
        return new FileUtilImp();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    }

    @Bean
    public XmlParser xmlParser() {
        return new XmlParserImp();
    }

    @Bean
    public ValidationUtil validationUtil() {
        return new ValidationUtilImp();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
