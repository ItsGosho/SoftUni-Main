package org.softuni.fdmc.data.models;

import org.softuni.fdmc.data.models.persons.PersonImp;

public class Cat {
    private String name;

    private String breed;

    private String color;

    private Integer numberOfLegs;

    private PersonImp creator;

    private int views;

    public Cat(String name, String breed, String color, Integer numberOfLegs, PersonImp creator) {
        this.setName(name);
        this.setBreed(breed);
        this.setColor(color);
        this.setNumberOfLegs(numberOfLegs);
        this.setCreator(creator);
        this.views=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(Integer numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public PersonImp getCreator() {
        return creator;
    }

    public void setCreator(PersonImp creator) {
        this.creator = creator;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void plusView(){
        this.views++;
    }
}
