package product_shop;

import product_shop.gson_parser.GsonParser;
import product_shop.models.Category;
import product_shop.models.Product;
import product_shop.models.User;
import product_shop.models.dto_infos.ProductInfoDto;
import product_shop.models.dtos.CategoryDto;
import product_shop.models.dtos.ProductDto;
import product_shop.models.dtos.UserDto;
import product_shop.services.CategoryServices;
import product_shop.services.ProductServices;
import product_shop.services.UserServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.aop.AopInvocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
public class ConsoleRunner implements CommandLineRunner {
     private UserServices userServices;
     private ProductServices productServices;
     private CategoryServices categoryServices;

    @Autowired
    public ConsoleRunner(UserServices userServices, ProductServices productServices, CategoryServices categoryServices) {
        this.userServices = userServices;
        this.productServices = productServices;
        this.categoryServices = categoryServices;
    }

    @Override
    public void run(String... strings) throws Exception {
         //insertData();
        productInfo();
    }

    public void insertData() throws FileNotFoundException {
        ModelMapper modelMapper=new ModelMapper();
        UserDto[] userDtos=GsonParser.parseUsers("C:\\Users\\Gosho\\Desktop\\DB\\#14.JSON Processing Exercises\\src\\main\\resources\\users.json");
        ProductDto[] productDtos=GsonParser.parseProducts("C:\\Users\\Gosho\\Desktop\\DB\\#14.JSON Processing Exercises\\src\\main\\resources\\products.json");
        CategoryDto[] categoryDtos=GsonParser.parseCategory("C:\\Users\\Gosho\\Desktop\\DB\\#14.JSON Processing Exercises\\src\\main\\resources\\categories.json");

        User[] users=modelMapper.map(userDtos,User[].class);
        for (User user : users) {
            this.userServices.saveUser(user);
        }

        Category[] categories=modelMapper.map(categoryDtos,Category[].class);
        for (Category category : categories) {
            this.categoryServices.saveCategory(category);
        }

        Product[] products=modelMapper.map(productDtos,Product[].class);
        for (Product product : products) {
            Random random=new Random();
            User userBuyer=this.userServices.findUserById(random.nextInt(users.length));
            product.setBuyer(userBuyer);
            User userSeller=this.userServices.findUserById(random.nextInt(users.length));
            product.setSeller(userSeller);
            product.setCategory(new LinkedHashSet<>());
            for (int i = 0; i < random.nextInt(3); i++) {
                Category category=this.categoryServices.findCategoryById(random.nextInt(categories.length));
                product.getCategory().add(category);
            }
            this.productServices.saveProduct(product);
        }
    }
    public void exportProductsInRange(){
        ModelMapper modelMapper=new ModelMapper();
        List<Product> products=this.productServices.getProductsByPriceBetweenAndBuyerIsNull(new BigDecimal(500),new BigDecimal(1000));
        Gson gson=new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        java.lang.reflect.Type targetListType = new TypeToken<List<ProductDto>>() {}.getType();
        List<ProductDto> productsDto=modelMapper.map(products,targetListType);
        String json=gson.toJson(productsDto,targetListType);
        System.out.println(json);
    }
    public void productInfo(){
        ModelMapper modelMapper=new ModelMapper();
       List<Category> category=this.categoryServices.getAll();
        List<ProductInfoDto> productInfoDto=new LinkedList<>();
        for (Category category1 : category) {
            try{
                ProductInfoDto productInfoDto1=new ProductInfoDto();
                productInfoDto1.setName(category1.getName());
                productInfoDto1.setProductsCount(this.productServices.countProductsByCategoryEquals(category1));
                productInfoDto1.setAveragePrice(this.productServices.getAveragePrice(category1));
                productInfoDto1.setTotalRevenue(this.productServices.getTotalSum(category1));
                productInfoDto.add(productInfoDto1);
            }catch (AopInvocationException ex){

            }
        }
        Gson gson=new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        java.lang.reflect.Type targetListType = new TypeToken<List<ProductInfoDto>>() {}.getType();
        String json=gson.toJson(productInfoDto,targetListType);
        System.out.println(json);
    }
}
