package product_shop.repository;

import product_shop.models.Category;
import product_shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> getProductsByPriceBetweenAndBuyerIsNull(BigDecimal min, BigDecimal max);

    int countProductsByCategoryEquals(Category category);

    @Query("select avg(c.price) from Product as c where :vhod member of c.category")
    double getAveragePrice(@Param("vhod") Category category);

    @Query("select sum(c.price) from Product as c where :vhod member of c.category")
    double getTotalSum(@Param("vhod") Category category);
}
