import java.util.Scanner;
import java.util.function.Consumer;

public class T02_KnightsOfHonor {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(" ");
        Consumer<String> sirAdd=vhod-> System.out.println("Sir "+vhod);
        for (int i = 0; i < line.length; i++) {
            sirAdd.accept(line[i]);
        }
    }
}
