package entities.characters.heroes;

public class MarvelHero extends Hero{
    public MarvelHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return ((super.getEnergy()+super.getSpecial())*super.getIntelligence())/2.5;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(super.toString());
        str.append(String.format("####Marvel Attack Power: %.2f",attack()));
        return str.toString();
    }
}
