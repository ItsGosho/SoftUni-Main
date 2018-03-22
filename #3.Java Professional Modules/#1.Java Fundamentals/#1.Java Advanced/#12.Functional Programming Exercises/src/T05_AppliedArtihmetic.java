import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class T05_AppliedArtihmetic {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        while (true) {
            String vhod = skener.nextLine();
            if (vhod.equals("end")) {
                break;
            }
          damn(arr,vhod);
        }

    }

    public static void damn(int[] arr, String command) {
        BiFunction<int[], String, Integer[]> test =
                (x, y) -> {
                    if (y.equals("add")) {
                        for (int i = 0; i < x.length; i++) {
                            x[i] += 1;
                        }
                    } else if (y.equals("multiply")) {
                        for (int i = 0; i < x.length; i++) {
                            x[i] *= 2;
                        }
                    } else if (y.equals("print")) {
                        for (int i = 0; i < x.length; i++) {
                            System.out.print(x[i]+" ");
                        }
                    } else if (y.equals("subtract")) {
                        for (int i = 0; i < x.length; i++) {
                            x[i] -= 1;
                        }
                    }
                    return null;
                };
        test.apply(arr,command);
    }
}
