package cresla.entities.models.reactors;

import cresla.interfaces.Container;

public class HeatReactor extends ReactorImpl {

    private int  heatReductionIndex;
    private Container container;

    public HeatReactor(Container container, int id, int heatReductionIndex) {
        super(container, id);
        this.heatReductionIndex = heatReductionIndex;
        this.container=container;
    }

    @Override
    public long getTotalHeatAbsorbing() {
            return super.getTotalHeatAbsorbing()+heatReductionIndex;
    }

    public int getHeatReductionIndex() {
        return heatReductionIndex;
    }
}
