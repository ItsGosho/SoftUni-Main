import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class T08_FindTheSmallestElement {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            if (!line[i].equals("")) {
                arr.add(Integer.parseInt(line[i]));
            }
        }
        Function<ArrayList<Integer>, Integer> indexReturn =
                x -> {
                     int minIndex=-1;
                     int maxIndex= Integer.MAX_VALUE;
                    for (int i = 0; i < x.size(); i++) {
                        if(x.get(i) <=maxIndex){
                            maxIndex=x.get(i);
                            minIndex=i;
                        }
                    }
                    return minIndex;
                };
        System.out.println(indexReturn.apply(arr));
    }
}
