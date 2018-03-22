import java.util.Scanner;
import java.util.function.Predicate;

public class T07_PredicateForNames {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int n=Integer.parseInt(skener.nextLine());
        String[] line = skener.nextLine().split(" ");
        Predicate<String> check=x->x.length()<=n;
        for (int i = 0; i < line.length; i++) {
            if(check.test(line[i])){
                System.out.println(line[i]);
            }
        }
    }
}
