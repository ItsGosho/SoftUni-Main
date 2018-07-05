package product_shop.models.dtos;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDto implements Serializable {

    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "price")
    private BigDecimal price;
    @XmlAttribute(name = "buyer")
    private UserDto buyer;
    @XmlAttribute(name = "seller")
    private UserDto seller;
    @XmlAttribute(name = "category")
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
