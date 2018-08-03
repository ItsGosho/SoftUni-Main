package hell.interfaces;

/**
 *  This is the interface for the ItemImp entity
 *  @method String getName() - a getter for the name property of the ItemImp
 *  @method long getStrengthBonus() - a getter for the strengthBonus property of the ItemImp
 *  @method long getAgilityBonus() - a getter for the agilityBonus property of the ItemImp
 *  @method long getIntelligenceBonus() - a getter for the intelligenceBonus property of the ItemImp
 *  @method long getHitPointsBonus() - a getter for the hitPointsBonus property of the ItemImp
 *  @method long getDamageBonus() - a getter for the damageBonus property of the ItemImp
 */
public interface Item {
    String getName();

    int getStrengthBonus();

    int getAgilityBonus();

    int getIntelligenceBonus();

    int getHitPointsBonus();

    int getDamageBonus();
}