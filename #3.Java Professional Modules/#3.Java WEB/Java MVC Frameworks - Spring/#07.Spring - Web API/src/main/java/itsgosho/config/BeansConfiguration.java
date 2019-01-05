package itsgosho.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class BeansConfiguration {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }

//    @Bean
//    public WebMvcConfigurer corsConfiguration(){
//        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/*").allowedOrigins("http://localhost:63342")
//                .allowedHeaders("Access-Control-Allow-Origin");
//            }
//        };
//    }
}
