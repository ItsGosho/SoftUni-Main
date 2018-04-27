package T08_militaryElite.Models;


import T08_militaryElite.Interfaces.iLeutenantGeneral;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LeutenantGeneral extends Private implements iLeutenantGeneral {
    private List<Private> privates;

    public LeutenantGeneral(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates=new ArrayList<>();
    }
    public void addPrivate(Private _private){
        privates.add(_private);
    }
    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getSecondName() {
        return super.getSecondName();
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public List<Private> getPrivates() {
        return this.privates;
    }
}
