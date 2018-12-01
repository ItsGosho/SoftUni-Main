package org.softuni.mostwanted.domain.dtos.imports.json;

import javax.validation.constraints.NotNull;

public class TownImportJSONDto {

    @NotNull
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
