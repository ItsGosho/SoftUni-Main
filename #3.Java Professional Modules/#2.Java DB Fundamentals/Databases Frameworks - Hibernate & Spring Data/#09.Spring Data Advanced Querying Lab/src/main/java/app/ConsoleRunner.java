package app;

import app.model.enums.Size;
import app.model.ingredients.BasicIngredient;
import app.model.shampoos.BasicShampoo;
import app.repository.BasicIngredientRepository;
import app.repository.BasicLabelRepository;
import app.repository.BasicShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.persistence.Basic;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {

    private BasicIngredientRepository basicIngredientRepository;
    private BasicLabelRepository basicLabelRepository;
    private BasicShampooRepository basicShampooRepository;

    @Autowired
    public ConsoleRunner(BasicIngredientRepository basicIngredientRepository, BasicLabelRepository basicLabelRepository, BasicShampooRepository basicShampooRepository) {
        this.basicIngredientRepository = basicIngredientRepository;
        this.basicLabelRepository = basicLabelRepository;
        this.basicShampooRepository = basicShampooRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        t12_update_ingredients_by_name();

    }

    public void t01_select_shampoos_by_size(){
        List<BasicShampoo> basicShampooList=this.basicShampooRepository.getBasicShampoosBySizeOrderById(Size.MEDIUM);
        for (BasicShampoo basicShampoo : basicShampooList) {
            System.out.println(basicShampoo.getBrand()+" "+basicShampoo.getSize().name()+" "+basicShampoo.getPrice()+"lv.");
        }
    }
    public void t02_select_shampoos_by_size_and_label(){
        List<BasicShampoo> basicShampooList=this.basicShampooRepository.getBasicShampoosBySizeAndLabelIdOrderByPriceAsc(Size.MEDIUM,10);
        for (BasicShampoo basicShampoo : basicShampooList) {
            System.out.println(basicShampoo.getBrand()+" "+basicShampoo.getSize().name()+" "+basicShampoo.getPrice()+"lv.");
        }
    }
    public void t03_select_shampoos_by_price(){
        List<BasicShampoo> basicShampooList=this.basicShampooRepository.getBasicShampoosByPriceGreaterThanOrderByPriceDesc(new BigDecimal(5));
        for (BasicShampoo basicShampoo : basicShampooList) {
            System.out.println(basicShampoo.getBrand()+" "+basicShampoo.getSize().name()+" "+basicShampoo.getPrice()+"lv.");
        }
    }
    public void t04_select_ingredients_by_name(){
        List<BasicIngredient> basicIngredientsList=this.basicIngredientRepository.getBasicIngredientsByNameStartingWith("M");
        for (BasicIngredient basicIngredient : basicIngredientsList) {
            System.out.println(basicIngredient.getName());
        }
    }
    public void t05_select_ingredients_by_names(){
        List<String> testList=new ArrayList<>();
        testList.add("Lavender");
        testList.add("Herbs");
        testList.add("Apple");
        List<BasicIngredient> basicIngredientList = this.basicIngredientRepository.getBasicIngredientsByNameIn(testList);
        for (BasicIngredient basicIngredient : basicIngredientList) {
            System.out.println(basicIngredient.getName());
        }
    }
    public void t06_count_shampoos_by_price(){
         int sz = this.basicShampooRepository.getBasicShampoosByPriceLessThan(new BigDecimal(8.50)).size();
        System.out.println(sz);
    }
    public void t07_select_shampoos_by_ingredients(){
        List<BasicIngredient> ingredientList=new ArrayList<>();
        ingredientList.add(this.basicIngredientRepository.findOne(10L));
        ingredientList.add(this.basicIngredientRepository.findOne(11L));

        List<BasicShampoo> basicShampooList = this.basicShampooRepository.getBasicShampoosByIngredientsIn(ingredientList);

        for (BasicShampoo basicShampoo : basicShampooList) {
            System.out.println(basicShampoo.getBrand());
        }
    }
    public void t08_select_shampoos_by_ingredients_count(){
        List<BasicShampoo> basicShampooList=this.basicShampooRepository.getBasicShampoosCountLess(1);
        for (BasicShampoo basicShampoo : basicShampooList) {
            System.out.println(basicShampoo.getBrand());
        }
    }
    public void t09_select_ing_name_and_shampoo_name_by_brand(){
        BigDecimal price = this.basicShampooRepository.getTotalIngredientCostForShampoo("Silk Comb");
        System.out.println(price);
    }
    public void t10_delete_ingredients_by_name(){
        this.basicIngredientRepository.deleteIngredientOfName("Apple");
    }
    public void t11_update_ingredient_price(){
         this.basicIngredientRepository.updateIngredientsPrice();
    }
    public void t12_update_ingredients_by_name(){
         List<String> names=new ArrayList<>();
         names.add("Nettle");
         names.add("Berry");
         this.basicIngredientRepository.updateIngredientsPriceByGivenNames(names);
    }
}
