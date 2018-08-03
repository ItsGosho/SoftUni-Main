package cresla.entities.models.modules;

import cresla.interfaces.EnergyModule;

public class CryogenRod extends ModuleImpl implements EnergyModule {

    private int  energyOutput;

    public CryogenRod(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(super.toString());
        str.append(String.format("Energy Output: %d",this.getEnergyOutput()));
        return str.toString();
    }
}
