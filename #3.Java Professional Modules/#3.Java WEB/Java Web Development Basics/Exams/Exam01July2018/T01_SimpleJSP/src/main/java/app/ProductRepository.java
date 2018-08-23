package app;

import java.util.LinkedList;
import java.util.List;

public class ProductRepository {

    private static List<Product> products = new LinkedList<>();

    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(List<Product> products) {
        ProductRepository.products = products;
    }

    public static Product getByName(String name){
        return products.stream().filter(x->x.getName().equals(name)).findFirst().get();
    }
}
