package T07_CarSalesman;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {
    static class Car {
        public String model="";
        public String engine="";
        public String weight="";
        public String color="";
        public static LinkedHashMap<String,Car> cars=new LinkedHashMap<>();
        public void addCar(String[] line) {
            this.model=line[0];
            Car car=new Car(line);
            if(!Car.cars.containsKey(this.model)){
                if(Car.cars.get(this.model).engine.equals(line[1])){
                    System.exit(0);
                }
            }
            Car.cars.put(this.model,car);
        }
        public Car(){

        }
        public Car(String line[]){
            this.model=line[0];
            this.engine=line[1];
            try{
                this.weight=String.valueOf(Integer.parseInt(line[2]));
            }catch(ArrayIndexOutOfBoundsException e){
                this.weight="n/a";
                this.color="n/a";
            }catch (NumberFormatException ex){
                this.weight="n/a";
                this.color=line[2];
            }
            try{
                if(!this.color.equals("n/a") && this.color.isEmpty()) {
                    this.color = line[3];
                }
            }catch(ArrayIndexOutOfBoundsException e){
                this.color="n/a";
            }
        }
    }

    static class Engine {
        public String model="";
        public int power=0;
        public String displacement="";
        public String efficienty="";
        public static LinkedHashMap<String, Engine> engines = new LinkedHashMap<>();

        public void addEngine(String[] line) {
            this.model = line[0];
            Engine engine=new Engine(line);
            Engine.engines.put(this.model,engine);
        }
        public Engine(){

        }
        public Engine(String[] line){
            this.model=line[0];
            this.power = Integer.parseInt(line[1]);
            try{
                this.displacement=String.valueOf(Integer.parseInt(line[2]));
            }catch(ArrayIndexOutOfBoundsException e){
                this.displacement="n/a";
                this.efficienty="n/a";
            }catch (NumberFormatException ex){
                this.displacement="n/a";
                this.efficienty=line[2];
            }
            try{
                if(!this.efficienty.equals("n/a") && this.efficienty.isEmpty()) {
                    this.efficienty = line[3];
                }
            }catch(ArrayIndexOutOfBoundsException e){
                this.efficienty="n/a";
            }
        }
    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int n = Integer.parseInt(skener.nextLine());
        Engine engine = new Engine();
        for (int i = 0; i < n; i++) {
            String[] line = skener.nextLine().split("\\s");
            engine.addEngine(line);
        }
        int n2 = Integer.parseInt(skener.nextLine());
        Car car=new Car();
        for (int i = 0; i < n2; i++) {
            String[] line = skener.nextLine().split("\\s");
            car.addCar(line);
        }
        Car.cars.entrySet().stream()
                .forEach(x->{
                    System.out.println(x.getKey()+":");
                    Engine.engines.entrySet().stream().filter(c->c.getKey().equals(x.getValue().engine))
                            .forEach(a-> {
                                System.out.println("  "+a.getKey()+":");
                                System.out.println("    Power: "+a.getValue().power);
                                System.out.println("    Displacement: "+a.getValue().displacement);
                                System.out.println("    Efficiency: "+a.getValue().efficienty);
                            });
                    System.out.println("  Weight: "+x.getValue().weight);
                    System.out.println("  Color: "+x.getValue().color);
                });
    }
}
