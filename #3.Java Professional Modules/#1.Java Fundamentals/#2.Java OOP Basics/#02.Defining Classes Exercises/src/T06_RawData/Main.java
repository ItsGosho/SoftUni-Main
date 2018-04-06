package T06_RawData;

import java.util.*;

public class Main {
    static class Car {
        private String model;
        private static LinkedHashMap<String, List<Cargo>> carsCargo = new LinkedHashMap<>();
        private static LinkedHashMap<String, List<Engine>> carsEngine = new LinkedHashMap<>();
        private static LinkedHashMap<String, List<Tire>> carsTire = new LinkedHashMap<>();

        public void addCar(String[] line) {
            this.model = line[0];
            Engine engine=new Engine(Integer.parseInt(line[2]), Integer.parseInt(line[1]));
            Tire tire = new Tire(Double.parseDouble(line[5])
                    , Integer.parseInt(line[6])
                    , Double.parseDouble(line[7])
                    , Integer.parseInt(line[8])
                    , Double.parseDouble(line[9])
                    , Integer.parseInt(line[10])
                    , Double.parseDouble(line[11])
                    , Integer.parseInt(line[12]));
            Cargo cargo = new Cargo(line[4]);
            Car.carsCargo.put(this.model, new ArrayList<Cargo>());
            Car.carsCargo.get(this.model).add(cargo);
            Car.carsEngine.put(this.model, new ArrayList<Engine>());
            Car.carsEngine.get(this.model).add(engine);
            Car.carsTire.put(this.model, new ArrayList<Tire>());
            Car.carsTire.get(this.model).add(tire);
        }

        public void printCar(String toPrint) {
            if(toPrint.equals("flamable")){
                Car.carsCargo.entrySet().stream().filter(x->x.getValue().get(0).cargoType.equals(toPrint))
                        .forEach(x->{
                            Car.carsEngine.get(x.getKey())
                                    .stream().filter(a->a.enginePower>=250)
                                    .forEach(z-> System.out.println(x.getKey()));
                        });
            }else if(toPrint.equals("fragile")){
                Car.carsCargo.entrySet().stream().filter(x->x.getValue().get(0).cargoType.equals(toPrint))
                        .forEach(x->{
                            Car.carsTire.get(x.getKey())
                                    .stream().filter(a->a.pressure1<1 && a.pressure2<1 && a.pressure3<1 && a.pressure4<=1.1)
                                    .forEach(z-> System.out.println(x.getKey()));
                        });
            }
        }
    }
    static class Cargo {
        public String cargoType;
        Cargo(String cargoType){
            this.cargoType=cargoType;
        }
    }
    static class Engine {
        public int enginePower;
        public int engineSpeed;

        public Engine(int enginePower, int engineSpeed) {
            this.enginePower = enginePower;
            this.engineSpeed = engineSpeed;
        }
    }
    static class Tire {
        public double pressure1;
        private int age1;
        public double pressure2;
        private int age2;
        public double pressure3;
        private int age3;
        public double pressure4;
        private int age4;

        public Tire(double pr1, int age1, double pr2, int age2, double pr3, int age3, double pr4, int age4) {
            this.pressure1 = pr1;
            this.age1 = age1;
            this.pressure2 = pr2;
            this.age2 = age2;
            this.pressure3 = pr3;
            this.age3 = age3;
            this.pressure4 = pr4;
            this.age4 = age4;
        }
    }

    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Car car = new Car();
        int n = Integer.parseInt(skener.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = skener.nextLine().split(" ");
            car.addCar(line);
        }
        String toPrint = skener.nextLine();
        car.printCar(toPrint);
    }
}
