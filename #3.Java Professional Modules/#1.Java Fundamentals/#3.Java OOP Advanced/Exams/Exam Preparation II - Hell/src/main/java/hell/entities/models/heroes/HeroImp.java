package hell.entities.models.heroes;

import hell.entities.miscellaneous.HeroInventory;
import hell.interfaces.Hero;
import hell.interfaces.Inventory;
import hell.interfaces.Item;
import hell.interfaces.Recipe;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class HeroImp implements Hero {

    private String name;
    private int strength;
    private int agility;
    private int intelligence;
    private int hitPoints;
    private int damage;
    private Inventory inventory;

    HeroImp(String name, int strength, int agility, int intelligence, int hitPoints, int damage) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.inventory=new HeroInventory();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getStrength() {
        return this.inventory.getTotalStrengthBonus()+this.strength;
    }

    @Override
    public long getAgility() {
        return this.inventory.getTotalAgilityBonus()+this.agility;
    }

    @Override
    public long getIntelligence() {
        return this.inventory.getTotalIntelligenceBonus()+this.intelligence;
    }

    @Override
    public long getHitPoints() {
        return this.inventory.getTotalHitPointsBonus()+this.hitPoints;
    }

    @Override
    public long getDamage() {
        return this.inventory.getTotalDamageBonus()+this.damage;
    }

    @Override
    public Collection<Item> getItems() {
        Field field= null;
        try {
            field = this.inventory.getClass().getDeclaredField("commonItems");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            Map<String,Item> itemMap = (Map<String, Item>) field.get(this.inventory);
            List<Item> items= new LinkedList<>();
            items.addAll(itemMap.values());
            return items;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addItem(Item item) {
         this.inventory.addCommonItem(item);
    }

    @Override
    public void addRecipe(Recipe recipe) {
        this.inventory.addRecipeItem(recipe);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("Hero: %s, Class: %s%n",name,getClass().getSimpleName()));
        str.append(String.format("HitPoints: %d, Damage: %d%n",getHitPoints(),getDamage()));
        str.append(String.format("Strength: %d%n",getStrength()));
        str.append(String.format("Agility: %d%n",getAgility()));
        str.append(String.format("Intelligence: %d%n",getIntelligence()));
        if(this.getItems().size()==0){
            str.append(String.format("Items: None"));
        }else{
            str.append(String.format("Items:%n"));
            for (Item item : this.getItems()) {
                str.append(String.format("###Item: %s%n",item.getName()));
                str.append(String.format("###+%d Strength%n",item.getStrengthBonus()));
                str.append(String.format("###+%d Agility%n",item.getAgilityBonus()));
                str.append(String.format("###+%d Intelligence%n",item.getIntelligenceBonus()));
                str.append(String.format("###+%d HitPoints%n",item.getHitPointsBonus()));
                str.append(String.format("###+%d Damage%n",item.getDamageBonus()));
            }
        }
        return str.toString();
    }
}
