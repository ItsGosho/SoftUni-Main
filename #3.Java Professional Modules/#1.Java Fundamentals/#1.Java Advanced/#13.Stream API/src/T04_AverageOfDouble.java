import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Stream;

public class T04_AverageOfDouble {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Stream<String> vhod= Arrays.stream(skener.nextLine().split(" "));
        OptionalDouble avg=vhod.filter(x->!x.isEmpty()).mapToDouble(Double::parseDouble)
                .average();
        if(avg.isPresent()){
            System.out.printf("%.2f",avg.getAsDouble());
        }else{
            System.out.println("No match");
        }
    }
}
