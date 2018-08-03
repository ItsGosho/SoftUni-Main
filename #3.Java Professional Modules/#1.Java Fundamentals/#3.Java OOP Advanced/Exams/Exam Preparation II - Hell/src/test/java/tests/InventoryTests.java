package tests;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.Map;

public class InventoryTests {

    private Inventory inventory;
    private Item item;

    @Before
    public void setup(){
       this.inventory = new HeroInventory();
       this.item=Mockito.mock(Item.class);
    }

    @Test
    public void testGetTotalStrengthBonus(){
        Mockito.when(this.item.getStrengthBonus()).thenReturn(10);
        this.inventory.addCommonItem(this.item);
        Assert.assertEquals(10,this.inventory.getTotalStrengthBonus());
    }

    @Test
    public void testGetTotalAgilityBonus(){
        Mockito.when(this.item.getAgilityBonus()).thenReturn(25);
        this.inventory.addCommonItem(this.item);
        Assert.assertEquals(25,this.inventory.getTotalAgilityBonus());
    }

    @Test
    public void testGetTotalIntelligenceBonus(){
        Mockito.when(this.item.getIntelligenceBonus()).thenReturn(37);
        this.inventory.addCommonItem(this.item);
        Assert.assertEquals(37,this.inventory.getTotalIntelligenceBonus());
    }

    @Test
    public void testGetTotalHitPointsBonus(){
        Mockito.when(this.item.getHitPointsBonus()).thenReturn(9);
        this.inventory.addCommonItem(this.item);
        Assert.assertEquals(9,this.inventory.getTotalHitPointsBonus());
    }

    @Test
    public void testGetTotalDamageBonus(){
        Mockito.when(this.item.getDamageBonus()).thenReturn(2);
        this.inventory.addCommonItem(this.item);
        Assert.assertEquals(2,this.inventory.getTotalDamageBonus());
    }

    @Test
    public void testAddCommonItem() throws NoSuchFieldException, IllegalAccessException {
        this.inventory.addCommonItem(this.item);
        Field field=this.inventory.getClass().getDeclaredField("commonItems");
        field.setAccessible(true);
        Map<String, Item> commonItems = (Map<String, Item>) field.get(this.inventory);
        Assert.assertTrue(commonItems.containsValue(this.item));
    }

    @Test
    public void testAddRecipeItem() throws NoSuchFieldException, IllegalAccessException {
        Recipe recipe= Mockito.mock(Recipe.class);
        this.inventory.addRecipeItem(recipe);
        Field field=this.inventory.getClass().getDeclaredField("recipeItems");
        field.setAccessible(true);
        Map<String, Recipe> recipeItems = (Map<String, Recipe>) field.get(this.inventory);
        Assert.assertTrue(recipeItems.containsValue(recipe));
    }
}
