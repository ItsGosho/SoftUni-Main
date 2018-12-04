package mostwanted.domain.dtos.exports;

import java.util.List;

public class RacingCarsExportDto {

    private String name;
    private Integer age;
    private List<String> carsFormated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getCarsFormated() {
        return carsFormated;
    }

    public void setCarsFormated(List<String> carsFormated) {
        this.carsFormated = carsFormated;
    }
}
