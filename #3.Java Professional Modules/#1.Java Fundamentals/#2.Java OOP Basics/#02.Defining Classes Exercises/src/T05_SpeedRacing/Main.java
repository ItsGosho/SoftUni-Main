package T05_SpeedRacing;

import java.util.*;

public class Main{
    public static class Car{
        private String model;
        private double fuel;
        private double fuelCostPerKM;
        private double distanceTraveled;
        private static LinkedHashMap<String,List<Harakteristiki>> cars=new LinkedHashMap<>();

        public void printCar(){
            Car.cars.entrySet().stream()
                    .forEach(x->{
                        System.out.print(x.getKey()+" ");
                        Car.cars.get(x.getKey()).stream()
                                .forEach(a->{
                                    System.out.printf("%.2f %.0f",a.fuel,a.distanceTraveled);
                                });
                        System.out.println();
                    });
        }
        public void addCar(String model,Double fuel,Double fuelCostPerKM){
            this.model=model;
            this.fuel=fuel;
            this.fuelCostPerKM=fuelCostPerKM;
            Car.cars.put(model,new ArrayList<Harakteristiki>());
            Harakteristiki harakteristiki=new Harakteristiki(this.fuel,this.fuelCostPerKM,this.distanceTraveled);
            Car.cars.get(model).add(harakteristiki);
        }
        public void driveCar(String model,Double amountKM){
            Harakteristiki harakteristiki=Car.cars.get(model).get(0);
            double fuelCheck=amountKM*harakteristiki.getFuelCostPerKM();
            if(fuelCheck>harakteristiki.getFuel()){
                System.out.println("Insufficient fuel for the drive");
            }else{
                harakteristiki.setNewProperties(harakteristiki.getFuel()-fuelCheck,harakteristiki.getDistance()+amountKM);
                Car.cars.get(model).remove(0);
                Car.cars.get(model).add(harakteristiki);
            }
        }
    }
    static class Harakteristiki{
        public double fuel;
        public double fuelCostPerKM;
        public double distanceTraveled;
        public Harakteristiki(Double fuel,Double fuelCostPerKM,Double distanceTraveled){
            this.fuel=fuel;
            this.fuelCostPerKM=fuelCostPerKM;
            this.distanceTraveled=distanceTraveled;
        }
        public double getFuel(){
            return this.fuel;
        }
        public double getDistance(){
            return this.distanceTraveled;
        }
        public double getFuelCostPerKM(){
            return this.fuelCostPerKM;
        }
        public void setNewProperties(Double leftFuel,Double distanceTraveled){
            this.fuel=leftFuel;
            this.distanceTraveled=distanceTraveled;
        }
    }
    public static void main (String[] args){
        Scanner skener = new Scanner(System.in);
        int n=Integer.parseInt(skener.nextLine());
        //add cars
        Car car=new Car();
        for (int i = 0; i < n; i++) {
            String[] line=skener.nextLine().split(" ");
            car.addCar(line[0],Double.parseDouble(line[1]),Double.parseDouble(line[2]));
        }
        //on road baby ;d
        while(true){
            String line=skener.nextLine();
            if(line.equals("End")){
                car.printCar();
                break;
            }
            String[] vhod=line.split(" ");
            car.driveCar(vhod[1],Double.parseDouble(vhod[2]));
        }
    }
}