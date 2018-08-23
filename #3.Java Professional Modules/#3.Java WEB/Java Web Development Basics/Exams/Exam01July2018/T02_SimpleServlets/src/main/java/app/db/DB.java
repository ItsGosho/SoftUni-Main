package app.db;

import java.util.LinkedList;
import java.util.List;

public class DB {

    private static List<Product> products=new LinkedList<Product>();

    public static List<Product> getProducts() {
        return products;
    }

    public static void setProducts(List<Product> products) {
        DB.products = products;
    }
}
