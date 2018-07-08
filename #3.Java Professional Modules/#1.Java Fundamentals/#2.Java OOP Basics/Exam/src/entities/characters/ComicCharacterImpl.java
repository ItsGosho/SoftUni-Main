package entities.characters;

import entities.characters.interfaces.ComicCharacter;
import entities.powers.interfaces.SuperPower;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ComicCharacterImpl implements ComicCharacter {

    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> superPower;

    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.superPower = new LinkedList<>();
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        Matcher matcher=Pattern.compile("^([A-Za-z\\_]+)$").matcher(name);
        if(name.length()<=12 && name.length()>=2 && matcher.find()){
            this.name=name;
        }else{
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        }
    }
    @Override
    public int getEnergy() {
        return energy;
    }
    public void setEnergy(int energy) {
        if(energy>=0 && energy<=300){
            this.energy = energy;
        }else{
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }
    }
    @Override
    public double getHealth() {
        return health;
    }
    public void setHealth(double health) {
        if(health>=1){
            this.health = health;
        }else{
            throw new IllegalArgumentException("Health should be a possitive number!");
        }
    }
    @Override
    public double getIntelligence() {
        return intelligence;
    }
    public void setIntelligence(double intelligence) {
        if(intelligence<=200 && intelligence>=0){
            this.intelligence = intelligence;
        }else{
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
    }
    public List<SuperPower> getSuperPower() {
        return superPower;
    }
    public void setSuperPower(List<SuperPower> superPower) {
        this.superPower = superPower;
    }

    @Override
    public void takeDamage(double damage) {
          this.health-=damage;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
         this.setEnergy(energy);
         this.setHealth(health);
         this.setIntelligence(intelligence);
    }

    @Override
    public double attack() {
        return 0;
    }

    @Override
    public double getSpecial() {
        return 0;
    }

    @Override
    public String useSuperPowers() {
        if(this.getSuperPower().size()!=0){
            for (SuperPower power : superPower) {
                 this.setHealth(this.getHealth()+(power.getPowerPoints()*2));
                 this.setEnergy((int) (this.getEnergy()+power.getPowerPoints()));
            }
            return String.format("%s used his super powers!",this.getName());
        }else{
            return String.format("%s has no super powers!",this.getName());
        }
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
         this.getSuperPower().add(superPower);
    }

    @Override
    public String toString() {
        return String.format("#Name: %s%n" +
                "##Health: %.2f// Energy: %d// Intelligence: %.2f%n",getName(),getHealth(),getEnergy(),getIntelligence());
    }
}
