package itsgosho.services;

import itsgosho.domain.models.dtos.UserRegisterDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServices extends UserDetailsService {

    boolean register(UserRegisterDto userRegisterDto);
}
