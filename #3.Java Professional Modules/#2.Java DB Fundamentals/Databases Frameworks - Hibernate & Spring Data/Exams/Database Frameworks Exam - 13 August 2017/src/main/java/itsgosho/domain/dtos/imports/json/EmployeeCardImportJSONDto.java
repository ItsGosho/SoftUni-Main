package itsgosho.domain.dtos.imports.json;

import javax.validation.constraints.NotNull;

public class EmployeeCardImportJSONDto {

    @NotNull
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
