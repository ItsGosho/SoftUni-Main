import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class T03_CountUppercaseWords {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(" ");
        Predicate<String> checkForUp=x->x.charAt(0)==Character.toUpperCase(x.charAt(0));
        ArrayList<String> result=new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            if(checkForUp.test(line[i])){
                result.add(line[i]);
            }
        }
        System.out.println(result.size());
        for(String item:result){
            System.out.println(item);
        }
    }
}
