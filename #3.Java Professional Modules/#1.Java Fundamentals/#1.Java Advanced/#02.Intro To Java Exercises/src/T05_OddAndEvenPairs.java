import java.util.Arrays;
import java.util.Scanner;

public class T05_OddAndEvenPairs {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int[] nums = Arrays.stream(skener.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if(nums.length%2!=0){
            System.out.println("invalid length");
        }else{
            for (int i = 0; i < nums.length-1; i+=2) {

                if(nums[i]%2==0 && nums[i+1]%2!=0 || nums[i+1]%2==0 && nums[i]%2!=0 ){
                    System.out.printf("%d, %d -> different",nums[i],nums[i+1]);
                }else if(nums[i]%2==0 && nums[i+1]%2==0){
                    System.out.printf("%d, %d -> both are even",nums[i],nums[i+1]);
                }else if(nums[i]%2!=0 && nums[i+1]%2!=0){
                    System.out.printf("%d, %d -> both are odd",nums[i],nums[i+1]);
                }
                System.out.println();
            }
        }
    }
}
