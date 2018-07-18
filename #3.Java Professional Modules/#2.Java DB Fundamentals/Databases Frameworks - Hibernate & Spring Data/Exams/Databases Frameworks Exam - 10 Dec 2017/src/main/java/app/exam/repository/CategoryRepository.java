package app.exam.repository;

import app.exam.domain.entities.Category;
import app.exam.domain.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Integer> {
    Category getCategoryByName(String name);
}
