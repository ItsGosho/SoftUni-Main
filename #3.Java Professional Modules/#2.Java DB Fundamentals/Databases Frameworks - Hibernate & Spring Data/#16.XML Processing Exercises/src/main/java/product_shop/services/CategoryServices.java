package product_shop.services;

import product_shop.models.Category;

import java.util.List;

public interface CategoryServices {
    void saveCategory(Category category);
    Category findCategoryById(int id);

    List<Category> getAll();
}
