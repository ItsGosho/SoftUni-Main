package org.softuni.mostwanted.domain.dtos.imports.json;

import javax.validation.constraints.NotNull;

public class DistrictImportJSONDto {

    @NotNull
    private String name;

    private String townName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
