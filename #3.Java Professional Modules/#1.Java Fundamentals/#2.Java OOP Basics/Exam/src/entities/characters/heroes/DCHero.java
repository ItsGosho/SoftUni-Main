package entities.characters.heroes;

public class DCHero extends Hero{
    public DCHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return super.getEnergy()/1.5+super.getSpecial()+super.getIntelligence();
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(super.toString());
        str.append(String.format("####DC Attack Power: %.2f",attack()));
        return str.toString();
    }
}
