package itsgosho.config;

import itsgosho.domain.parsers.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguraton {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ValidationUtil getValidationUtil() {
        return new ValidationUtil();
    }
}
