import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T03_FirstName {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        Stream<String> names= Arrays.stream(skener.nextLine().split(" "))
                ;
        List<String> firstWord=Arrays.stream(skener.nextLine().split(" "))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        Optional<String> check=names
                .filter(x->firstWord.contains(String.valueOf(x.charAt(0))))
                .findFirst();

        if(check.isPresent()){
            System.out.println(check.get());
        }else {
            System.out.println("No match");
        }
    }
}
