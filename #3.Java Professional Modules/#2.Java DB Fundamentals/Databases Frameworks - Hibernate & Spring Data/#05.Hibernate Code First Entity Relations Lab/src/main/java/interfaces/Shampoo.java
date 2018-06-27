package interfaces;

import java.math.BigDecimal;

public interface Shampoo {
    long getId();
    void setId();
    String getBrand();
    void setBrand(String brand);
    BigDecimal getPrice();
    void setPrice(BigDecimal price);
    Size getSize();
    void setSize(Size size);
    BasicLabel getLabel();
    void setLabel(BasicLabel label);
    Set<BasicIngredient> getIngredients();
    void setIngredients(Set<BasicIngredient> ingredients);
}
