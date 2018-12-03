package itsgosho.domain.dtos.imports.json;

import javax.validation.constraints.NotNull;

public class TownImportJSONDto {

    @NotNull
    private String name;

    @NotNull
    private Long population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
