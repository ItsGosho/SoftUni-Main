package cresla.entities.models.modules;

import cresla.interfaces.Module;

public abstract class ModuleImpl implements Module {

    private int id;

    public ModuleImpl(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void removeFirst() {

    }

    @Override
    public String toString() {
        return String.format("%s Module - %d%n",this.getClass().getSimpleName(),id);
    }
}
