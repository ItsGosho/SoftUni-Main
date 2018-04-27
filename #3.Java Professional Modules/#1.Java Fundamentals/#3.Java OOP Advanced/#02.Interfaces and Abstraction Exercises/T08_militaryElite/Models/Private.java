package T08_militaryElite.Models;

import T08_militaryElite.Interfaces.iPrivate;

public class Private extends Soldier implements iPrivate {
    private double salary;
    public Private(String id, String firstName, String lastName,double salary) {
        super(id, firstName, lastName);
        this.salary=salary;
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
        return this.salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s Salary: %.2f",this.getFirstName(),this.getSecondName(),this.getId(),this.getSalary());
    }
}
