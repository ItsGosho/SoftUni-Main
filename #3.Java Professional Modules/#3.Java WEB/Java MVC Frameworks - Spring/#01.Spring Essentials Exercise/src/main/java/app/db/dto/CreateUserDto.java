package app.db.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class CreateUserDto {

    private String name;
    private String birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
}