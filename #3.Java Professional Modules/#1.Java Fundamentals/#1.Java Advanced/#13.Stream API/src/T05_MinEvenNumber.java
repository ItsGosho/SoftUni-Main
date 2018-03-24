import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class T05_MinEvenNumber {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        DoubleStream vhod= Arrays.stream(skener.nextLine().split(" "))
                .filter(x->!x.isEmpty())
                .mapToDouble(Double::parseDouble);
        OptionalDouble result=vhod
                .filter(x->x%2==0)
                .min();
        if(result.isPresent()){
            System.out.printf("%.2f",result.getAsDouble());
        }else{
            System.out.println("No match");
        }
    }
}
