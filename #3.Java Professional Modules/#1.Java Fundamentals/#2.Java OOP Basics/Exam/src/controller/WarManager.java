package controller;

import entities.arenas.ArenaImpl;
import entities.arenas.interfaces.Arena;
import entities.characters.ComicCharacterImpl;
import entities.characters.interfaces.ComicCharacter;
import entities.powers.interfaces.SuperPower;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WarManager implements Manager {

    private HashMap<String,ComicCharacter> comicCharacters;
    private HashMap<String,Arena> arenas;
    private HashMap<String,SuperPower> superPowers;
    private int[] battleResults;

    public WarManager(){
          this.comicCharacters=new LinkedHashMap<>();
          this.arenas=new LinkedHashMap<>();
          this.superPowers=new LinkedHashMap<>();
          this.battleResults=new int[3];
    }
    @Override
    public String checkComicCharacter(String characterName) {
        if(this.comicCharacters.containsKey(characterName)){
             if(this.comicCharacters.get(characterName).getHealth()>=1){
                return this.comicCharacters.get(characterName).toString();
             }else{
                 return String.format("%s has fallen in battle!",characterName);
             }
        }else{
            return String.format("Sorry, fans! %s doesn't exist in our comics!",characterName);
        }
    }

    @Override
    public String addHero(ComicCharacter hero) {
        if(!this.comicCharacters.containsKey(hero.getName())){
            //add
            this.comicCharacters.put(hero.getName(),hero);
            return String.format("%s is ready for battle!",hero.getName());
        }else{
            //boost
             this.comicCharacters.get(hero.getName()).boostCharacter(hero.getEnergy(),hero.getHealth(),hero.getIntelligence());
             return String.format("%s evolved!",hero.getName());
        }
    }

    @Override
    public String addAntiHero(ComicCharacter antiHero) {
        if(!this.comicCharacters.containsKey(antiHero.getName())){
            //add
            this.comicCharacters.put(antiHero.getName(),antiHero);
            return String.format("%s is ready for destruction!",antiHero.getName());
        }else{
            //boost
            this.comicCharacters.get(antiHero.getName()).boostCharacter(antiHero.getEnergy(),antiHero.getHealth(),antiHero.getIntelligence());
            return String.format("%s is getting stronger!",antiHero.getName());
        }
    }

    @Override
    public String addArena(Arena arena) {
        if(!arenas.containsKey(arena.getArenaName())){
            this.arenas.put(arena.getArenaName(),arena);
             return String.format("%s is becoming a fighting ground!",arena.getArenaName());
        }else {
            return String.format("A battle is about to start there!");
        }
    }

    @Override
    public String addHeroToArena(String arena, String hero) {
        final boolean[] isHeroInFight = {false};
        arenas.entrySet().stream().forEach(x->{
            ArenaImpl arenaStream= (ArenaImpl) x.getValue();
            for (ComicCharacter comicCharacter : arenaStream.getHeroes()) {
                if(comicCharacter.getName().equals(hero)){
                    isHeroInFight[0] =true;
                   break;
                }
            }
        });
        if(!isHeroInFight[0]){
            if(this.comicCharacters.get(hero).getHealth()>=1){
                 if(!this.arenas.get(arena).isArenaFull()){
                      this.arenas.get(arena).addHero(this.comicCharacters.get(hero));
                      return String.format("%s is fighting for your freedom in %s!",hero,arena);
                 }else{
                     return String.format("Arena is full!");
                 }
            }else{
                return String.format("%s is dead!",hero);
            }
        }else{
            return String.format("%s is fighting!",hero);
        }
    }

    @Override
    public String addAntiHeroToArena(String arena, String antiHero) {
        final boolean[] isAntiHeroInFights = {false};
        arenas.entrySet().stream().forEach(x->{
            ArenaImpl arenaStream= (ArenaImpl) x.getValue();
            for (ComicCharacter comicCharacter : arenaStream.getAntiHeroes()) {
                if(comicCharacter.getName().equals(antiHero)){
                    isAntiHeroInFights[0] =true;
                    break;
                }
            }
        });
        if(!isAntiHeroInFights[0]){
            if(this.comicCharacters.get(antiHero).getHealth()>=1){
                if(!this.arenas.get(arena).isArenaFull()){
                    this.arenas.get(arena).addAntiHero(this.comicCharacters.get(antiHero));
                    return String.format("%s and his colleagues are trying to take over %s!",antiHero,arena);
                }else{
                    return String.format("Arena is full!");
                }
            }else{
                return String.format("%s is dead!",antiHero);
            }
        }else{
            return String.format("%s is fighting!",antiHero);
        }
    }

    @Override
    public String loadSuperPowerToPool(SuperPower superPower) {
        if(!this.superPowers.containsKey(superPower.getName())){
            this.superPowers.put(superPower.getName(),superPower);
            return String.format("%s added to pool!",superPower.getName());
        }else{
            return String.format("This super power already exists!");
        }
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacter, String superPower) {
        ComicCharacterImpl character= (ComicCharacterImpl) this.comicCharacters.get(comicCharacter);
        final boolean[] alreadyContaisnSuperPower = {false};
        character.getSuperPower().stream().forEach(x->{
            if(x.getName().equals(superPower)){
                alreadyContaisnSuperPower[0] = true;
            }
        });
        this.comicCharacters.entrySet().stream().forEach(x->{
            ComicCharacterImpl comicChar= (ComicCharacterImpl) x.getValue();
            comicChar.getSuperPower().stream().forEach(c->{
                if(c.getName().equals(superPower)){
                    alreadyContaisnSuperPower[0] = true;
                }
            });
        });
        if(!alreadyContaisnSuperPower[0]){
             this.comicCharacters.get(comicCharacter).addSuperPower(this.superPowers.get(superPower));
             return String.format("%s has a new super power!",comicCharacter);
        }else{
            return String.format("%s already assigned!",superPower);
        }
    }

    @Override
    public String usePowers(String characterName) {
        ComicCharacterImpl comicCharacter= (ComicCharacterImpl) this.comicCharacters.get(characterName);
        if(comicCharacter.getSuperPower().size()!=0){
            this.comicCharacters.get(characterName).useSuperPowers();
            return String.format("%s used his super powers!",characterName);
        }else {
            return String.format("%s has no super powers!", characterName);
        }
    }

    @Override
    public String startBattle(String arena) {
       ArenaImpl area= (ArenaImpl) this.arenas.get(arena);
        int totalCount=area.getAntiHeroes().size()+area.getHeroes().size();
        if(totalCount!=0){
            if(this.arenas.get(arena).fightHeroes()){
                //true heroes win
                this.arenas.remove(arena);
                battleResults[0]++;
                battleResults[2]++;
                return String.format("Heroes won the battle of %s!",arena);
            }else{
                //false villians win
                this.arenas.remove(arena);
                battleResults[1]++;
                battleResults[2]++;
                return String.format("Anti Heroes won the battle of %s!",arena);
            }
        }else{
            return String.format("SAFE ZONE!");
        }
    }

    @Override
    public String endWar() {
        if(battleResults[0]>=battleResults[1]){
             return String.format("After %d battles our FRIENDLY HEROES WON!",battleResults[2]);
        }else{
            return String.format("WE ARE DOOMED!");
        }
    }
}
