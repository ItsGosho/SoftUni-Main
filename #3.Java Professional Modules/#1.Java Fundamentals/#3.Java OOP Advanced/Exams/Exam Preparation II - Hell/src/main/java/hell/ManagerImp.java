package hell;

import hell.entities.Config;
import hell.entities.models.heroes.Assassin;
import hell.entities.models.heroes.Barbarian;
import hell.entities.models.heroes.Wizard;
import hell.entities.models.items.CommonItem;
import hell.entities.models.items.RecipeItem;
import hell.interfaces.Hero;
import hell.interfaces.Item;
import hell.interfaces.Manager;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ManagerImp implements Manager {

    private Map<String, Hero> heroes;

    public ManagerImp() {
        this.heroes = new LinkedHashMap<>();
    }

    @Override
    public String addHero(String heroName, String heroType) {

        switch (heroType) {
            case "Barbarian":
                this.heroes.put(heroName,
                        new Barbarian(heroName,
                                Config.BARBARIAN_STRENGTH,
                                Config.BARBARIAN_AGILITY,
                                Config.BARBARIAN_INTELLIGENCE,
                                Config.BARBARIAN_HIT_POINTS,
                                Config.BARBARIAN_DAMAGE));
                break;
            case "Assassin":
                this.heroes.put(heroName,
                        new Assassin(heroName,
                                Config.ASSASSIN_STRENGTH,
                                Config.ASSASSIN_AGILITY,
                                Config.ASSASSIN_INTELLIGENCE,
                                Config.ASSASSIN_HIT_POINTS,
                                Config.ASSASSIN_DAMAGE));
                break;
            case "Wizard":
                this.heroes.put(heroName,
                        new Wizard(heroName,
                                Config.WIZARD_STRENGTH,
                                Config.WIZARD_AGILITY,
                                Config.WIZARD_INTELLIGENCE,
                                Config.WIZARD_HIT_POINTS,
                                Config.WIZARD_DAMAGE));
                break;
        }
        return String.format("Created %s - %s", heroType, heroName);
    }

    @Override
    public String addItem(String itemName, String heroName, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitpointsBonus, int damageBonus) {
        this.heroes.get(heroName).addItem(new CommonItem(itemName,
                strengthBonus, agilityBonus, intelligenceBonus, hitpointsBonus, damageBonus));
        return String.format("Added item - %s to Hero - %s", itemName, heroName);
    }

    @Override
    public String addRecipe(String itemName, String heroName, int strengthBonus, int agilityBonus, int intelligenceBonus, int hitpointsBonus, int damageBonus, String... requiredItems) {
        this.heroes.get(heroName).addRecipe(new RecipeItem(itemName,
                strengthBonus, agilityBonus, intelligenceBonus,
                hitpointsBonus, damageBonus, requiredItems));
        return String.format("Added recipe - %s to Hero - %s", itemName, heroName);
    }

    @Override
    public String inspect(String heroName) {
        return this.heroes.get(heroName).toString();
    }

    @Override
    public String quit() {
        final int[] counter = {1};
        StringBuilder str = new StringBuilder();
        this.heroes.entrySet().stream().sorted((x1, x2) -> {
            long x1Strength = x1.getValue().getStrength();
            long x1Agility = x1.getValue().getAgility();
            long x1Intelligence = x1.getValue().getIntelligence();
            long x2Strength = x2.getValue().getStrength();
            long x2Agility = x2.getValue().getAgility();
            long x2Intelligence = x2.getValue().getIntelligence();
            long x1SUM = x1Strength + x1Agility + x1Intelligence;
            long x2SUM = x2Strength + x2Agility + x2Intelligence;
            if (x1SUM != x2SUM) {
                return Long.compare(x2SUM, x1SUM);
            } else {
                return Long.compare(x2.getValue().getHitPoints() + x2.getValue().getDamage(), x1.getValue().getHitPoints() + x1.getValue().getDamage());
            }
        }).forEach(x -> {
            str.append(String.format("%d. %s: %s%n", counter[0], x.getValue().getClass().getSimpleName(), x.getKey()));
            str.append(String.format("###HitPoints: %d%n", x.getValue().getHitPoints()));
            str.append(String.format("###Damage: %d%n", x.getValue().getDamage()));
            str.append(String.format("###Strength: %d%n", x.getValue().getStrength()));
            str.append(String.format("###Agility: %d%n", x.getValue().getAgility()));
            str.append(String.format("###Intelligence: %d%n", x.getValue().getIntelligence()));
            try {
                if (x.getValue().getItems().size() == 0) {
                    str.append(String.format("###Items: None"));
                } else {
                    List<String> items=new LinkedList<>();
                    for (Item item : x.getValue().getItems()) {
                        items.add(item.getName());
                    }
                    str.append(String.format("###Items: %s%n",String.join(", ", items)));
                }
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            counter[0]++;
        });
        String test=str.toString();
        test = test.replaceAll("\\+","");
        return test;
    }
}
