package T08_PokemonTrainer;

import java.util.*;

public class Main {
    static class Trainer{
        public String name;
        public int numberOfBadges;
        public static LinkedHashMap<String,Integer> trainerInfo=new LinkedHashMap<>();
        public static LinkedHashMap<String,List<Pokemon>> trainerPokemons=new LinkedHashMap<>();
        public Trainer(String name,int numberOfBadges){
            this.name=name;
            this.numberOfBadges=numberOfBadges;
        }
        public static void addTrainerAndPokemon(String[] line){
            Trainer trainer=new Trainer(line[0],0);
            Pokemon pokemon=new Pokemon(line);
            if(!trainerInfo.containsKey(trainer.name)){
                trainerInfo.put(trainer.name,0);
                trainerPokemons.put(trainer.name,new ArrayList<>());
                trainerPokemons.get(trainer.name).add(pokemon);
            }else{
                trainerPokemons.get(trainer.name).add(pokemon);
            }
        }
        public static void battleTrainerAndPokemon(String element){
            Trainer.trainerPokemons.entrySet()
                    .forEach(x->{
                        boolean hasPokemon=false;
                        for (int i = 0; i < x.getValue().size(); i++) {
                            if(x.getValue().get(i).element.equals(element)){
                                hasPokemon=true;
                            }
                        }
                        if(hasPokemon){
                            Trainer.trainerInfo.put(x.getKey(),Trainer.trainerInfo.get(x.getKey())+1);
                        }else{
                            for (int i = 0; i < x.getValue().size(); i++) {
                                int newHealth=Trainer.trainerPokemons.get(x.getKey()).get(i).health-10;
                                Trainer.trainerPokemons.get(x.getKey()).get(i).health=newHealth;
                                if(Trainer.trainerPokemons.get(x.getKey()).get(i).health<=0){
                                    Trainer.trainerPokemons.get(x.getKey()).remove(i);
                                }
                            }
                        }
                    });
        }

        public static void printResult() {
            Trainer.trainerInfo.entrySet().stream()
                    .sorted((x1,x2)->{
                        int sum1=x1.getValue();
                        int sum2=x2.getValue();
                        return Integer.compare(sum2,sum1);
                    }).forEach(x->{
                System.out.println(x.getKey()+" "+x.getValue()+" "+Trainer.trainerPokemons.get(x.getKey()).size());
            });
        }
    }
    static class Pokemon{
        public String name;
        public String element;
        public int health;

        public Pokemon(String[] line){
            this.name=line[1];
            this.element=line[2];
            this.health=Integer.parseInt(line[3]);
        }

    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        while(true){
            String line=skener.nextLine();
            if(line.equals("Tournament")){
                 break;
            }
            String[] vhod=line.split(" ");
            Trainer.addTrainerAndPokemon(vhod);
        }
        while(true){
            String line=skener.nextLine();
            if(line.equals("End")){
                Trainer.printResult();
                break;
            }
            Trainer.battleTrainerAndPokemon(line);
        }
    }
}
