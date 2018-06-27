package interfaces;

import java.math.BigDecimal;

public interface Ingredient {
    String getName();
    void setName(String name);
    int getId();
    void setId();
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
    List<BasicShampoo> getShampoos();
    void setShampoos(List<BasicShampoo> shampoos);
}
