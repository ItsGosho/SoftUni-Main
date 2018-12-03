package itsgosho.domain.dtos.exports.json;

import com.google.gson.annotations.SerializedName;

public class ProductiveEmployeeExportJSONDto {

    @SerializedName("full_name")
    private String fullName;
    private String position;
    private String number;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
