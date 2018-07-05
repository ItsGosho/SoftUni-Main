package product_shop.gson_parser;

import product_shop.models.dtos.CategoryDto;
import product_shop.models.dtos.ProductDto;
import product_shop.models.dtos.UserDto;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GsonParser {

    private static Gson gsonInitialised(){
        Gson gson=new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        return gson;
    }
    public static UserDto[] parseUsers(String jsonPath) throws FileNotFoundException {
        UserDto[] userDtos=gsonInitialised().fromJson(new FileReader(jsonPath), UserDto[].class);
        return userDtos;
    }
    public static ProductDto[] parseProducts(String jsonPath) throws FileNotFoundException {
        ProductDto[] productDtos=gsonInitialised().fromJson(new FileReader(jsonPath), ProductDto[].class);
        return productDtos;
    }
    public static CategoryDto[] parseCategory(String jsonPath) throws FileNotFoundException {
        CategoryDto[] categoryDtos=gsonInitialised().fromJson(new FileReader(jsonPath), CategoryDto[].class);
        return categoryDtos;
    }
}
