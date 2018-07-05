package product_shop.services;

import product_shop.models.Category;
import product_shop.models.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductServices {
    void saveProduct(Product product);
    List<Product> getProductsByPriceBetweenAndBuyerIsNull(BigDecimal min, BigDecimal max);

    int countProductsByCategoryEquals(Category category);
    double getAveragePrice(Category category);
    double getTotalSum(Category category);
}
