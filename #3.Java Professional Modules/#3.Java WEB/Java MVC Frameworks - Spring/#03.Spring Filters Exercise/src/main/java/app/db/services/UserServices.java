package app.db.services;

import app.db.dtos.UserRegisterDto;
import org.springframework.stereotype.Service;

public interface UserServices {

    void create(UserRegisterDto userRegisterDto);
}
