package cresla.entities.models.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

import java.lang.reflect.Field;
import java.util.List;

public abstract class ReactorImpl implements Reactor {

    private int id;
    private Container container;

    public ReactorImpl(Container container,int id) {
        this.id = id;
        this.container=container;
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.container.getTotalEnergyOutput();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.container.getTotalHeatAbsorbing();
    }

    @Override
    public int getModuleCount() {
        int total=0;
        try {
            Field field=this.container.getClass().getDeclaredField("modulesByInput");
            field.setAccessible(true);
            try {
                List<Object> modules = (List<Object>) field.get(this.container);
                total=modules.size();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
         this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("%s - %d%n",this.getClass().getSimpleName(),id));
        long  tEnergy=this.getTotalEnergyOutput();
        long  tHeat=this.getTotalHeatAbsorbing();
        if(tEnergy>tHeat){
            str.append(String.format("Energy Output: 0%n"));
        }else{
            str.append(String.format("Energy Output: %d%n",this.getTotalEnergyOutput()));
        }
        str.append(String.format("Heat Absorbing: %d%n",this.getTotalHeatAbsorbing()));
        str.append(String.format("Modules: %d",this.getModuleCount()));
        return str.toString();
    }
}
