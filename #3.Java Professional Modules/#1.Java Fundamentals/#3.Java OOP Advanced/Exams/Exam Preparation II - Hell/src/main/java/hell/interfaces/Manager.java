package hell.interfaces;

public interface Manager {

    String addHero(String heroName,String heroType);

    String addItem(String itemName,String heroName,int strengthBonus,
                   int agilityBonus,int intelligenceBonus,
                   int hitpointsBonus,int damageBonus);

    String addRecipe(String itemName,String heroName,int strengthBonus,
                   int agilityBonus,int intelligenceBonus,
                   int hitpointsBonus,int damageBonus
    ,String... requiredItems);

    String inspect(String heroName);

    String quit();
}
