package T08_militaryElite.Models;

import T08_militaryElite.Interfaces.iSpecialisedSoldier;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecialisedSoldier extends Private implements iSpecialisedSoldier {
    private List<String> corps;

    public SpecialisedSoldier(String id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.corps=new ArrayList<>();
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
    public List<String> getCorps() {
        return this.corps;
    }
}
