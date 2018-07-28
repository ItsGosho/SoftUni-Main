package panzer.models.entities.parts;

import panzer.contracts.AttackModifyingPart;

import java.math.BigDecimal;

public class Arsenal extends PartImpl implements AttackModifyingPart {

    private int attackModifier;

    public Arsenal(String model, double weight, BigDecimal price, int attackModifier) {
        super(model, weight, price);
        this.attackModifier = attackModifier;
    }

    @Override
    public int getAttackModifier() {
        return this.attackModifier;
    }

    public void setAttackModifier(int attackModifier) {
        this.attackModifier = attackModifier;
    }

    @Override
    public String toString() {
        return String.format("Arsenal Part - %s%n+Attack %d",super.getModel(),getAttackModifier());
    }
}
