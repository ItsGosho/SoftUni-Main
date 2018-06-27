package t01_book_shop_system.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import t01_book_shop_system.models.Category;
import t01_book_shop_system.repositories.CategoryRepository;
import t01_book_shop_system.services.interfaces.CategoryServices;

@Service
@Primary
public class CategorySerImpl implements CategoryServices {
    private CategoryRepository categoryRepository;

    @Autowired
    public CategorySerImpl(CategoryRepository categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    @Override
    public void registerCategory(Category category) {
        categoryRepository.save(category);
    }
}
