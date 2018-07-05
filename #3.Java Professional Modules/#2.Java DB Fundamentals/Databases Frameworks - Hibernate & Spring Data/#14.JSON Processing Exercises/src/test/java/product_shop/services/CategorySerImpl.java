package product_shop.services;

import product_shop.models.Category;
import product_shop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorySerImpl implements CategoryServices {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategorySerImpl(CategoryRepository categoryRepository) {
        this.categoryRepository=categoryRepository;
    }

    @Override
    public void saveCategory(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category findCategoryById(int id) {
        return this.categoryRepository.findCategoryById(id);
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }
}
