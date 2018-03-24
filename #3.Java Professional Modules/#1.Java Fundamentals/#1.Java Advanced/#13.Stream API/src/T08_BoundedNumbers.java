import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T08_BoundedNumbers {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        List<Integer> vhod= Arrays.stream(skener.nextLine().split(" "))
                .map(Integer::parseInt)
                .filter(x->(x>=arr[0] && x<=arr[1]) ||
                        (x>=arr[1] && x<=arr[0]))
                .collect(Collectors.toList());
        for (int i = 0; i < vhod.size(); i++) {
            System.out.print(vhod.get(i)+" ");
        }
    }
}
