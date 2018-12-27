package itsgosho.config;

import itsgosho.config.validators.ValidationUtil;
import itsgosho.domain.repositories.UserRepository;
import itsgosho.domain.validators.UserRegisterDtoValidator;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ValidationUtil getValidationUtil(){
        return new ValidationUtil();
    }
}
