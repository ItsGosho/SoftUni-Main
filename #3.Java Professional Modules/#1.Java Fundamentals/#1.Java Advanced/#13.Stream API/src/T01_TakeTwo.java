import java.util.Arrays;
import java.util.Scanner;

public class T01_TakeTwo {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Arrays.stream(arr).filter(x->x>=10 && x<=20).distinct().limit(2)
                .forEach(x-> System.out.print(x+" "));
    }
}
