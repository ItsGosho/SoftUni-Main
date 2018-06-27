package app.repository;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.shampoos.BasicShampoo;
import app.model.shampoos.Shampoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BasicShampooRepository extends JpaRepository<BasicShampoo, Long> {

    List<BasicShampoo> getBasicShampoosBySizeOrderById(Size size);
    List<BasicShampoo> getBasicShampoosBySizeAndLabelIdOrderByPriceAsc(Size size, long id);
    List<BasicShampoo> getBasicShampoosByPriceGreaterThanOrderByPriceDesc(BigDecimal price);
    List<BasicShampoo> getBasicShampoosByPriceLessThan(BigDecimal price);

    @Query("select bs from BasicShampoo as bs join bs.ingredients  as i where i in :ingName")
    List<BasicShampoo> getBasicShampoosByIngredientsIn(@Param("ingName")List<BasicIngredient> ingridients);

    @Query("select bs from BasicShampoo as bs where bs.ingredients.size > :ingCount ")
    List<BasicShampoo> getBasicShampoosCountLess(@Param("ingCount")int count);

    @Query("select sum(i.price) from BasicShampoo as bs join bs.ingredients as i where bs.brand = :inputShampoo")
    BigDecimal getTotalIngredientCostForShampoo(@Param("inputShampoo")String shampoo);
}