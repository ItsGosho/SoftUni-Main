package app.retake.domain.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class AnimalJSONImportDTO implements Serializable {

    @Expose
    private String name;
    @Expose
    private String type;
    @Expose
    private int age;
    @Expose
    @SerializedName(value = "passport")
    private PassportJSONImportDTO passportJSONImportDTO;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PassportJSONImportDTO getPassportJSONImportDTO() {
        return passportJSONImportDTO;
    }

    public void setPassportJSONImportDTO(PassportJSONImportDTO passportJSONImportDTO) {
        this.passportJSONImportDTO = passportJSONImportDTO;
    }
}
