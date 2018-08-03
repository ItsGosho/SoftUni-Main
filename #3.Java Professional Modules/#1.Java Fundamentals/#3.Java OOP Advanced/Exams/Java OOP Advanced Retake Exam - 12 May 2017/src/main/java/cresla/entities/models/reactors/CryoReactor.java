package cresla.entities.models.reactors;

import cresla.interfaces.Container;

public class CryoReactor extends ReactorImpl {

    private int cryoProductionIndex;
    private Container container;

    public CryoReactor(Container container, int id, int cryoProductionIndex) {
        super(container, id);
        this.cryoProductionIndex = cryoProductionIndex;
        this.container=container;
    }

    @Override
    public long getTotalEnergyOutput() {
        long  tEnergy=super.getTotalEnergyOutput();
        long  tHeat=super.getTotalHeatAbsorbing();
        if(tEnergy>tHeat){
            return 0;
        }else{
            if(super.getTotalEnergyOutput()!=0 && cryoProductionIndex!=0){
                return super.getTotalEnergyOutput()*cryoProductionIndex;
            }else{
                return super.getTotalEnergyOutput();
            }
        }
    }

    public int getCryoProductionIndex() {
        return cryoProductionIndex;
    }
}
