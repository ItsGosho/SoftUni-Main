package product_shop.services;

import product_shop.models.Category;
import product_shop.models.Product;
import product_shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductSerImpl implements ProductServices {
    private ProductRepository productRepository;

    @Autowired
    public ProductSerImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByPriceBetweenAndBuyerIsNull(BigDecimal min, BigDecimal max) {
        return this.productRepository.getProductsByPriceBetweenAndBuyerIsNull(min,max);
    }

    @Override
    public int countProductsByCategoryEquals(Category category) {
        return this.productRepository.countProductsByCategoryEquals(category);
    }

    @Override
    public double getAveragePrice(Category category) {
        return this.productRepository.getAveragePrice(category);
    }

    @Override
    public double getTotalSum(Category category) {
        return this.productRepository.getTotalSum(category);
    }
}
