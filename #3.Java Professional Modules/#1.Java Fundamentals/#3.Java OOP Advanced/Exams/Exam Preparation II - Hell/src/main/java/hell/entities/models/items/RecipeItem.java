package hell.entities.models.items;

import hell.interfaces.Recipe;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RecipeItem extends ItemImp implements Recipe {

    private List<String> requiredItems;

    public RecipeItem(String name, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitPointsBonus, int damageBonus,String... requiredItems) {
        super(name, strengthBonus, agilityBonus, intelligenceBonus, hitPointsBonus, damageBonus);
        this.requiredItems = new LinkedList<>();
        this.requiredItems.addAll(Arrays.asList(requiredItems));
    }


    @Override
    public List<String> getRequiredItems() {
        return this.requiredItems;
    }
}
