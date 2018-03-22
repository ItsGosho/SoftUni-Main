import java.util.Scanner;
import java.util.function.Consumer;

public class T01_StudentsByGroup {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(" ");
        String a="";
        Consumer<String> print=vhod-> System.out.println(vhod);
        for (int i = 0; i < line.length; i++) {
            print.accept(line[i]);
        }
    }
}
