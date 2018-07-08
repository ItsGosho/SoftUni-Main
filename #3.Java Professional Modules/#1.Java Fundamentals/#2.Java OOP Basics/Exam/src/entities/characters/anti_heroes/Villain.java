package entities.characters.anti_heroes;

public class Villain extends AntiHero{
    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (super.getIntelligence()*super.getSpecial())/super.getEnergy();
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(super.toString());
        str.append(String.format("####Villain Attack Power: %.2f",attack()));
        return str.toString();
    }
}
