package t01_book_shop_system.repositories;

import org.springframework.data.repository.CrudRepository;
import t01_book_shop_system.models.Category;

public interface CategoryRepository extends CrudRepository<Category,Integer> {

}
