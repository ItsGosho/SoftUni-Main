package cresla.entities.containers;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;

import java.util.*;

public class ModuleContainer implements Container {

    private int moduleCapacity;
    private List<Module> modulesByInput;
    private Map<Integer, EnergyModule> energyModules;
    private Map<Integer, AbsorbingModule> absorbingModules;

    public ModuleContainer(int moduleCapacity) {
        this.moduleCapacity = moduleCapacity;
        this.modulesByInput = new LinkedList<>();
        this.energyModules = new LinkedHashMap<>();
        this.absorbingModules = new LinkedHashMap<>();
    }

    public void addEnergyModule(EnergyModule energyModule) {
        if (energyModule == null) {
            throw new IllegalArgumentException();
        }

        if (this.modulesByInput.size() == this.moduleCapacity) {
            int removeId = this.energyModules.get(0).getId();
            Module removeModule= this.energyModules.get(removeId);
            this.modulesByInput.remove(removeModule);
            this.energyModules.remove(removeId);
        }

        this.energyModules.put(energyModule.getId(), energyModule);
        this.modulesByInput.add(energyModule);
    }

    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        if (absorbingModule == null) {
            throw new IllegalArgumentException();
        }

        if (this.modulesByInput.size() == this.moduleCapacity) {
            int removeId = this.modulesByInput.get(0).getId();
            Module removeModule= this.absorbingModules.get(removeId);
            this.modulesByInput.remove(removeModule);
            this.absorbingModules.remove(removeId);
        }

        this.absorbingModules.put(absorbingModule.getId(), absorbingModule);
        this.modulesByInput.add(absorbingModule);
    }

    @Override
    public long getTotalEnergyOutput() {
        return this.energyModules.values().stream()
                .mapToLong(EnergyModule::getEnergyOutput)
                .sum();
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return this.absorbingModules.values().stream()
                .mapToLong(AbsorbingModule::getHeatAbsorbing)
                .sum();
    }

    private void removeOldestModule() {
        int removeId = this.modulesByInput.get(0).getId();
        this.modulesByInput.remove(removeId);
    }
}