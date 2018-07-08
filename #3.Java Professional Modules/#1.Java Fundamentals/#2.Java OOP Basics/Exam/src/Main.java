import controller.WarManager;
import entities.arenas.ArenaImpl;
import entities.characters.anti_heroes.Titan;
import entities.characters.anti_heroes.Villain;
import entities.characters.heroes.DCHero;
import entities.characters.heroes.MarvelHero;
import entities.powers.Power;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        WarManager warManager=new WarManager();
        while (true){
            String line=skener.nextLine();
            if(line.equals("WAR_IS_OVER")){
                System.out.println(warManager.endWar());
                break;
            }
            String[] splitted=line.split("\\s+");
            switch (splitted[0]){
                case "CHECK_CHARACTER":
                    System.out.println(warManager.checkComicCharacter(splitted[1]));
                    break;
                case "REGISTER_HERO":
                    switch (splitted[2]){
                        case "DCHero":
                            try{
                            System.out.println(warManager.addHero(new DCHero(splitted[1],
                                    Integer.parseInt(splitted[3]),
                                    Double.parseDouble(splitted[4]),
                                    Double.parseDouble(splitted[5]),
                                    Double.parseDouble(splitted[6])
                            )));
                            }catch (IllegalArgumentException ex){
                                System.out.println(ex.getMessage());
                            }
                            break;
                        case "MarvelHero":
                            try{
                                System.out.println(warManager.addHero(new MarvelHero(splitted[1],
                                        Integer.parseInt(splitted[3]),
                                        Double.parseDouble(splitted[4]),
                                        Double.parseDouble(splitted[5]),
                                        Double.parseDouble(splitted[6])
                                )));
                            }catch (IllegalArgumentException ex){
                                System.out.println(ex.getMessage());
                            }
                            break;
                    }
                    break;
                case "REGISTER_ANTI_HERO":
                    switch (splitted[2]){
                        case "Titan":
                            try{
                            System.out.println(warManager.addAntiHero(new Titan(splitted[1],
                                    Integer.parseInt(splitted[3]),
                                    Double.parseDouble(splitted[4]),
                                    Double.parseDouble(splitted[5]),
                                    Double.parseDouble(splitted[6])
                            )));
                            }catch (IllegalArgumentException ex){
                                System.out.println(ex.getMessage());
                            }
                            break;
                        case "Villain":
                            try{
                            System.out.println(warManager.addAntiHero(new Villain(splitted[1],
                                    Integer.parseInt(splitted[3]),
                                    Double.parseDouble(splitted[4]),
                                    Double.parseDouble(splitted[5]),
                                    Double.parseDouble(splitted[6])
                            )));
                            }catch (IllegalArgumentException ex){
                                System.out.println(ex.getMessage());
                            }
                            break;
                    }
                    break;
                case "BUILD_ARENA":
                    System.out.println(warManager.addArena(new ArenaImpl(splitted[1], Integer.parseInt(splitted[2]))));
                    break;
                case "SEND_HERO":
                    System.out.println(warManager.addHeroToArena(splitted[1], splitted[2]));
                    break;
                case "SEND_ANTI_HERO":
                    System.out.println(warManager.addAntiHeroToArena(splitted[1], splitted[2]));
                    break;
                case "SUPER_POWER":
                    try {
                        System.out.println(warManager.loadSuperPowerToPool(new Power(splitted[1], Double.parseDouble(splitted[2]))));
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "ASSIGN_POWER":
                    System.out.println(warManager.assignSuperPowerToComicCharacter(splitted[1], splitted[2]));
                    break;
                case "UNLEASH":
                    try {
                        System.out.println(warManager.usePowers(splitted[1]));
                    }catch (IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "COMICS_WAR":
                    System.out.println(warManager.startBattle(splitted[1]));
                    break;
            }
        }
    }
}
