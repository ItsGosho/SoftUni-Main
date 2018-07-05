package product_shop.repository;

import product_shop.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    Category findCategoryById(int id);

}
