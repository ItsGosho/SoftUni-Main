package itsgosho.services.inter;

import itsgosho.domain.entities.Branch;
import itsgosho.domain.entities.Product;

public interface ProductServices {

    boolean save(Product product);
    void seedDatabase();
}
