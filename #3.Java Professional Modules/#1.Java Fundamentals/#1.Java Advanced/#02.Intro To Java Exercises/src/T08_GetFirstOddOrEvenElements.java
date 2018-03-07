import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class T08_GetFirstOddOrEvenElements {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int[] nums= Arrays.stream(skener.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String line1=skener.nextLine();
        String[] line=line1.split(" ");
        int broiElement=Integer.parseInt(line[1]);
        String oddOrEven=line[2];

        int doSega=0;
        if(oddOrEven.equals("even")){
            for (int i = 0; i <nums.length ; i++) {
                if(nums[i]%2==0 && doSega!=broiElement){
                    System.out.print(nums[i]+" ");
                    doSega++;
                }
            }
        }else if(oddOrEven.equals("odd")){
            for (int i = 0; i <nums.length ; i++) {
                if(nums[i]%2!=0 && doSega!=broiElement){
                    System.out.print(nums[i]+" ");
                    doSega++;
                }
            }
        }
    }
}
