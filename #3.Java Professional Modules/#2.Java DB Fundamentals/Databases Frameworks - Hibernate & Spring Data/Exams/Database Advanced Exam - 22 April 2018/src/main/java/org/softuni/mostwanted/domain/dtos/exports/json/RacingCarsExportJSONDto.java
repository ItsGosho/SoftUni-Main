package org.softuni.mostwanted.domain.dtos.exports.json;

import com.google.gson.annotations.Expose;

public class RacingCarsExportJSONDto {

    private String name;
    private Integer age;
    private String[] cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getCars() {
        return cars;
    }

    public void setCars(String[] cars) {
        this.cars = cars;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
