package cresla;

import cresla.entities.containers.ModuleContainer;
import cresla.entities.models.modules.CooldownSystem;
import cresla.entities.models.modules.CryogenRod;
import cresla.entities.models.modules.HeatProcessor;
import cresla.entities.models.reactors.CryoReactor;
import cresla.entities.models.reactors.HeatReactor;
import cresla.interfaces.Container;
import cresla.interfaces.Manager;
import cresla.interfaces.Module;
import cresla.interfaces.Reactor;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.*;

public class ManagerImpl implements Manager {

    private Map<Integer, Reactor> idReactor;
    private List<Module> modules;
    private int counter;
    private int totalCryoReactors;
    private int totalHeatReactors;
    private int totalEnergyModules;
    private int totalAbsorbingModules;

    public ManagerImpl() {
        this.idReactor = new LinkedHashMap<>();
        this.modules=new LinkedList<>();
        this.counter = 1;
        this.totalCryoReactors=0;
        this.totalHeatReactors=0;
        this.totalEnergyModules=0;
        this.totalAbsorbingModules=0;
    }

    @Override
    public String reactorCommand(List<String> arguments) {
        String reactorType = arguments.get(1);
        int additionalParameter = Integer.parseInt(arguments.get(2));
        int moduleCapacity = Integer.parseInt(arguments.get(3));

        int rId=counter;
        switch (reactorType) {
            case "Cryo":
                this.idReactor.put(counter, new CryoReactor(new ModuleContainer(moduleCapacity), counter, additionalParameter));
                this.totalCryoReactors++;
                break;
            case "Heat":
                this.idReactor.put(counter, new HeatReactor(new ModuleContainer(moduleCapacity), counter, additionalParameter));
                this.totalHeatReactors++;
                break;
        }
        counter++;
        return String.format("Created %s Reactor - %d", reactorType, rId);
    }

    @Override
    public String moduleCommand(List<String> arguments) {
        int reactorid = Integer.parseInt(arguments.get(1));
        String type = arguments.get(2);
        int additionalParameter = Integer.parseInt(arguments.get(3));

        int mId=counter;
        switch (type) {
            case "CryogenRod":
                this.idReactor.get(reactorid).addEnergyModule(new CryogenRod(counter, additionalParameter));
                this.modules.add(new CryogenRod(counter, additionalParameter));
                this.totalEnergyModules++;
                break;
            case "HeatProcessor":
                this.idReactor.get(reactorid).addAbsorbingModule(new HeatProcessor(counter, additionalParameter));
                this.modules.add(new HeatProcessor(counter, additionalParameter));
                this.totalAbsorbingModules++;
                break;
            case "CooldownSystem":
                this.idReactor.get(reactorid).addAbsorbingModule(new CooldownSystem(counter, additionalParameter));
                this.modules.add(new CooldownSystem(counter, additionalParameter));
                this.totalAbsorbingModules++;
                break;
        }
        counter++;
        return String.format("Added %s - %d to Reactor - %d", type, mId, reactorid);
    }

    @Override
    public String reportCommand(List<String> arguments) throws NoSuchFieldException, IllegalAccessException {
        int id = Integer.parseInt(arguments.get(1));
        StringBuilder str = new StringBuilder();
        if (this.idReactor.containsKey(id)) {
            //reactors
            str.append(this.idReactor.get(id).toString());
        } else {
            for (Module module : this.modules) {
                if(module.getId()==id){
                    str.append(module.toString());
                    break;
                }
            }
        }

        return str.toString();
    }

    @Override
    public String exitCommand(List<String> arguments) {
        //PRINT DETAILED STATS
        StringBuilder str=new StringBuilder();
        str.append(String.format("Cryo Reactors: %d%n",this.totalCryoReactors));
        str.append(String.format("Heat Reactors: %d%n",this.totalHeatReactors));
        str.append(String.format("Energy Modules: %d%n",this.totalEnergyModules));
        str.append(String.format("Absorbing Modules: %d%n",this.totalAbsorbingModules));
        long totalEnergyOutput=0;
        for (Reactor value : this.idReactor.values()) {
            totalEnergyOutput+=value.getTotalEnergyOutput();
        }
        long totalAbsorbing=0;
        for (Reactor value : this.idReactor.values()) {
                totalAbsorbing+=value.getTotalHeatAbsorbing();
        }
        str.append(String.format("Total Energy Output: %d%n",totalEnergyOutput));
        str.append(String.format("Total Heat Absorbing: %d",totalAbsorbing));
        return str.toString();
    }
}
