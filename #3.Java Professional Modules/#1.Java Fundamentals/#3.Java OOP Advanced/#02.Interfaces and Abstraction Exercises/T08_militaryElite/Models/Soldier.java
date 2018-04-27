package T08_militaryElite.Models;

import T08_militaryElite.Interfaces.iSoldier;

public abstract class Soldier implements iSoldier {
    private String id;
    private String firstName;
    private String lastName;

    public Soldier(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getSecondName() {
        return this.lastName;
    }
}
