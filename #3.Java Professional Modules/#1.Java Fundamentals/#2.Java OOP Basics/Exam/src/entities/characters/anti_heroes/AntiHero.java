package entities.characters.anti_heroes;

import entities.characters.ComicCharacterImpl;

public abstract class AntiHero extends ComicCharacterImpl {
    private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence,double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    public double getEvilness() {
        return evilness;
    }
    public void setEvilness(double evilness) {
        if(evilness>=0){
            this.evilness = evilness;
        }else{
            throw new IllegalArgumentException("Evilness should be a possitive number!");
        }
    }
    @Override
    public double getSpecial() {
        return getEvilness();
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(super.toString());
        str.append(String.format("###Evilness: %.2f%n",getEvilness()));
        return str.toString();
    }
}
