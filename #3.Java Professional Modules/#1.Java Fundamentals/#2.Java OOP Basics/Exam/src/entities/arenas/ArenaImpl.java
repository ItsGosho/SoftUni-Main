package entities.arenas;

import entities.arenas.interfaces.Arena;
import entities.characters.anti_heroes.AntiHero;
import entities.characters.heroes.Hero;
import entities.characters.interfaces.ComicCharacter;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArenaImpl implements Arena {

    private String arenaName;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;
    private int capacity;

    public ArenaImpl(String arenaName, int capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
        this.heroes=new LinkedList<>();
        this.antiHeroes=new LinkedList<>();
    }

    public String getArenaName() {
        return arenaName;
    }
    public void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }
    public List<ComicCharacter> getHeroes() {
        return heroes;
    }
    public void setHeroes(List<ComicCharacter> heroes) {
        this.heroes = heroes;
    }
    public List<ComicCharacter> getAntiHeroes() {
        return antiHeroes;
    }
    public void setAntiHeroes(List<ComicCharacter> antiHeroes) {
        this.antiHeroes = antiHeroes;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean isArenaFull() {
        int count=this.heroes.size()+this.antiHeroes.size();
        if(count>=capacity){
           return true;
        }else{
            return false;
        }
    }

    @Override
    public void addHero(ComicCharacter hero) {
          this.getHeroes().add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
            this.getAntiHeroes().add(antiHero);
    }

    boolean isMadeFirstCheck=false;
    boolean heroesAttack=false;
    boolean evilsAttack=false;
    @Override
    public boolean fightHeroes() {
        //how much they will fight
        while (true){
            if(this.heroes.size()==0){
                //heroes lose
                return false;
            }else if(this.antiHeroes.size()==0){
                //anti heroes lose
                return true;
            }

            List<ComicCharacter> deathHeroesNames=new LinkedList<>();
            List<ComicCharacter> deathVilliansNames=new LinkedList<>();

            if(heroes.size()>=antiHeroes.size() && !isMadeFirstCheck){
               //ANTI HEROES ATTACK
                isMadeFirstCheck=true;
                evilsAttack=true;
            }else if(heroes.size()<antiHeroes.size() && !isMadeFirstCheck){
                isMadeFirstCheck=true;
                heroesAttack=true;
            }
            if(evilsAttack){
                final int[] positionCounter = {0};
                this.antiHeroes.stream().forEach(x->{
                    try {
                        this.getHeroes().get(positionCounter[0]).takeDamage(x.attack());
                        if (this.getHeroes().get(positionCounter[0]).getHealth() <= 0) {
                            deathHeroesNames.add(this.getHeroes().get(positionCounter[0]));
                        }
                    }catch (IndexOutOfBoundsException ex){};
                    positionCounter[0]++;
                });
                evilsAttack=false;
                heroesAttack=true;
            }else if(heroesAttack){
                final int[] positionCounter = {0};
                this.heroes.stream().forEach(x->{
                    try {
                        this.getAntiHeroes().get(positionCounter[0]).takeDamage(x.attack());
                        if (this.getAntiHeroes().get(positionCounter[0]).getHealth() <= 0) {
                            deathVilliansNames.add(this.getAntiHeroes().get(positionCounter[0]));
                        }
                    }catch (IndexOutOfBoundsException ex){};
                    positionCounter[0]++;
                });
                heroesAttack=false;
                evilsAttack=true;
            }
            //clear the walking dead ;) ;d
            for (int i = 0; i < deathHeroesNames.size(); i++) {
                this.heroes.remove(deathHeroesNames.get(i));
            }

            for (int i = 0; i < deathVilliansNames.size(); i++) {
                this.antiHeroes.remove(deathVilliansNames.get(i));
            }
        }
    }
}
