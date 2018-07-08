package entities.characters.heroes;

import entities.characters.ComicCharacterImpl;

public abstract class Hero extends ComicCharacterImpl {
    private double heroism;

    public Hero(String name, int energy, double health, double intelligence,double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    public double getHeroism() {
        return heroism;
    }
    public void setHeroism(double heroism) {
        if(heroism>=0){
            this.heroism = heroism;
        }else{
            throw new IllegalArgumentException("Heroism should be a possitive number!");
        }
    }
    @Override
    public double getSpecial() {
        return getHeroism();
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(super.toString());
        str.append(String.format("###Heroism: %.2f%n",getHeroism()));
        return str.toString();
    }
}
