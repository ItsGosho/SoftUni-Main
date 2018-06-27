package app.repository;

import app.model.ingredients.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface BasicIngredientRepository extends JpaRepository<BasicIngredient,Long> {

    List<BasicIngredient> getBasicIngredientsByNameStartingWith(String letter);
    List<BasicIngredient> getBasicIngredientsByNameIn(List<String> name);

    @Modifying
    @Transactional
    @Query("delete from BasicIngredient as b where b.name = :name")
    void deleteIngredientOfName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("update BasicIngredient as b set b.price=b.price*1.10")
    void updateIngredientsPrice();

    @Modifying
    @Transactional
    @Query("update BasicIngredient as b set b.price=b.price*1.10 where b.name in :names")
    void updateIngredientsPriceByGivenNames(@Param("names") List<String> names);
}
