package product_shop.models.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductDto implements Serializable {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private UserDto buyer;
    @Expose
    private UserDto seller;
    @Expose
    private List<CategoryDto> category;

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

    public UserDto getBuyer() {
        return buyer;
    }

    public void setBuyer(UserDto buyer) {
        this.buyer = buyer;
    }

    public UserDto getSeller() {
        return seller;
    }

    public void setSeller(UserDto seller) {
        this.seller = seller;
    }

    public List<CategoryDto> getCategory() {
        return category;
    }

    public void setCategory(List<CategoryDto> category) {
        this.category = category;
    }
}
