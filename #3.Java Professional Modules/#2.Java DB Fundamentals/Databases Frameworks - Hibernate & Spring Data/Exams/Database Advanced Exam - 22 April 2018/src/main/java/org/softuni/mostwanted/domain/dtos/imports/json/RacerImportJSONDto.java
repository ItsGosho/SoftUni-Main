package org.softuni.mostwanted.domain.dtos.imports.json;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class RacerImportJSONDto {

    @NotNull
    private String name;
    private int age;
    private BigDecimal bounty;
    private String homeTown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBounty() {
        return bounty;
    }

    public void setBounty(BigDecimal bounty) {
        this.bounty = bounty;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }
}
