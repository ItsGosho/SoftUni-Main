package app.exam.domain.dto.json;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ItemJSONImportDTO {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
