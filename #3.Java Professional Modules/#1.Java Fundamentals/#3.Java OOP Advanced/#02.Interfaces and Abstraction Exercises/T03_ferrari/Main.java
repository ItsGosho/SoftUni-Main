package T03_ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) throws IllegalClassFormatException {
        Scanner skener = new Scanner(System.in);
        String name=skener.nextLine();
        Car car=new Ferrari(name);
        System.out.println(car.toString());
        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }

    }
}
