package itsgosho.config;

import itsgosho.interceptors.PreAuthenticateInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    private final PreAuthenticateInterceptor preAuthenticateInterceptor;

    public InterceptorConfiguration(PreAuthenticateInterceptor preAuthenticateInterceptor) {
        this.preAuthenticateInterceptor = preAuthenticateInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
         registry.addInterceptor(this.preAuthenticateInterceptor);
    }
}
