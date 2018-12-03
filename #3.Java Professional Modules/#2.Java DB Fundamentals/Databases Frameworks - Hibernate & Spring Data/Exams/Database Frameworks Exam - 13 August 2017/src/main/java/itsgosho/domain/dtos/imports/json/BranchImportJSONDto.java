package itsgosho.domain.dtos.imports.json;

import javax.validation.constraints.NotNull;

public class BranchImportJSONDto {

    @NotNull
    private String name;

    @NotNull
    private String town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
