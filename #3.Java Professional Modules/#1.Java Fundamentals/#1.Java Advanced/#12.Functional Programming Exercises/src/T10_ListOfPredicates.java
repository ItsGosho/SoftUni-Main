import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class T10_ListOfPredicates {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        int num=Integer.parseInt(skener.nextLine());
        String[] line = skener.nextLine().split(" ");
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            if (!line[i].equals("")) {
                nums.add(Integer.parseInt(line[i]));
            }
        }
        boolean dong=true;
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < nums.size(); j++) {
                int FinalJ=j;
                Predicate<Integer> check=x->x%nums.get(FinalJ)==0;
                if(!check.test(i)){
                   dong=false;
                }
            }
            if(dong){
                System.out.print(i+" ");
            }
            dong=true;
        }
    }
}
