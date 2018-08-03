package cresla.entities.models.modules;

import cresla.interfaces.AbsorbingModule;

public class CooldownSystem extends ModuleImpl implements AbsorbingModule {

    private int  heatAbsorbing;

    public CooldownSystem(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(super.toString());
        str.append(String.format("Heat Absorbing: %d",this.getHeatAbsorbing()));
        return str.toString();
    }
}
