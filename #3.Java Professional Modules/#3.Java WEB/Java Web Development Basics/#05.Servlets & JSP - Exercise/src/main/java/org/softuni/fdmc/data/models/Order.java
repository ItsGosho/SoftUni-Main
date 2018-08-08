package org.softuni.fdmc.data.models;

import org.softuni.fdmc.data.models.persons.Person;

import java.time.LocalDateTime;

public class Order {

    private Person user;
    private Cat cat;
    private LocalDateTime madeOn;

    public Order(Person user, Cat cat, LocalDateTime madeOn) {
        this.user = user;
        this.cat = cat;
        this.madeOn = madeOn;
    }

    public Order() {

    }

    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public LocalDateTime getMadeOn() {
        return madeOn;
    }

    public void setMadeOn(LocalDateTime madeOn) {
        this.madeOn = madeOn;
    }
}
