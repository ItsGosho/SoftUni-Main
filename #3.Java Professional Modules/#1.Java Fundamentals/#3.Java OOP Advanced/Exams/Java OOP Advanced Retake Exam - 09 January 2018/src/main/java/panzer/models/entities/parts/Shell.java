package panzer.models.entities.parts;

import panzer.contracts.DefenseModifyingPart;

import java.math.BigDecimal;

public class Shell extends PartImpl implements DefenseModifyingPart {

    private int defenseModifier;

    public Shell(String model, double weight, BigDecimal price, int defenseModifier) {
        super(model, weight, price);
        this.defenseModifier = defenseModifier;
    }

    public void setDefenseModifier(int defenseModifier) {
        this.defenseModifier = defenseModifier;
    }

    @Override
    public int getDefenseModifier() {
        return defenseModifier;
    }

    @Override
    public String toString() {
        return String.format("Shell Part - %s%n+Attack %d",super.getModel(),getDefenseModifier());
    }
}
