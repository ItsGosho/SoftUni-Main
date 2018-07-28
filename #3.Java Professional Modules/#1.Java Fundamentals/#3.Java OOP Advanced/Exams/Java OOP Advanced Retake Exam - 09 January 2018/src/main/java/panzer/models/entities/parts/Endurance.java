package panzer.models.entities.parts;

import panzer.contracts.HitPointsModifyingPart;

import java.math.BigDecimal;

public class Endurance extends PartImpl implements HitPointsModifyingPart {

    private int hitPointsModifier;

    public Endurance(String model, double weight, BigDecimal price, int hitPointsModifier) {
        super(model, weight, price);
        this.hitPointsModifier = hitPointsModifier;
    }

    @Override
    public int getHitPointsModifier() {
        return hitPointsModifier;
    }

    public void setHitPointsModifier(int hitPointsModifier) {
        this.hitPointsModifier = hitPointsModifier;
    }

    @Override
    public String toString() {
        return String.format("Endurance Part - %s%n+Attack %d",super.getModel(),getHitPointsModifier());
    }
}
